package org.apphatchery.training.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewModelScope
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.apphatchery.training.R
import org.apphatchery.training.Utils
import org.apphatchery.training.data.local.MessageEntity
import org.apphatchery.training.databinding.ActivityMainBinding
import org.apphatchery.training.domain.model.Message
import org.apphatchery.training.messages


@AndroidEntryPoint
class MainActivity : AppCompatActivity() ,MainAdapter.OnClickListener{

    private val viewModel: MainViewModel by viewModels()
    private lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var bind: ActivityMainBinding
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val bottomSheetView = layoutInflater.inflate(R.layout.bottonsheet, null)
        val usernameInput = bottomSheetView.findViewById<EditText>(R.id.username_input)
        val messageInput = bottomSheetView.findViewById<EditText>(R.id.message_input)
        val submitButton = bottomSheetView.findViewById<Button>(R.id.submit_button)

        bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        val mainAdapter = MainAdapter(this)
        viewModel.viewModelScope.launch {
            viewModel.query().collect{
                mainAdapter.submitList( it.map { MessageEntity->MessageEntity.toMessage() })
            }
        }

        bind.recyclerView.apply {
            adapter = mainAdapter
        }

        val fab = bind.fab
        fab.setOnClickListener {
            bottomSheetDialog.show()

        }
        submitButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                viewModel.upsert(MessageEntity(usernameInput.text.toString(), messageInput.text.toString()))
            }
            bottomSheetDialog.dismiss()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onItemClick(message: Message) {
        Toast.makeText(this.applicationContext, "${message.id}", Toast.LENGTH_SHORT).show()
        GlobalScope.launch(Dispatchers.IO) {
            viewModel.delete(MessageEntity(username = message.username, message = message.message,id=message.id))
        }
    }

}