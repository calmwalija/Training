package org.apphatchery.training.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewModelScope
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
import org.apphatchery.training.messages


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var bind: ActivityMainBinding
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val mainAdapter = MainAdapter()
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
            val messageEntity = MessageEntity("kennedy", "good morning")
            GlobalScope.launch(Dispatchers.IO) {
                viewModel.upsert(messageEntity)
            }


        }

    }

}