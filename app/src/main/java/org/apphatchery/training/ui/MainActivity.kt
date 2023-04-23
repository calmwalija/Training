package org.apphatchery.training.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.apphatchery.training.R
import org.apphatchery.training.Utils
import org.apphatchery.training.data.local.MessageEntity
import org.apphatchery.training.databinding.ActivityMainBinding
import org.apphatchery.training.messages


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val mainAdapter = MainAdapter()

        val messageEntity = MessageEntity("Wiza", "Hello there")

        bind.add.setOnClickListener { viewModel.upsert(messageEntity) }



        bind.recyclerView.apply {
            adapter = mainAdapter
        }

//        mainAdapter.submitList(messages)

    }

}