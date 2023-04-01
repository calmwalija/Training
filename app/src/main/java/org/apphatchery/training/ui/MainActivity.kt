package org.apphatchery.training.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.apphatchery.training.R
import org.apphatchery.training.Utils
import org.apphatchery.training.databinding.ActivityMainBinding
import org.apphatchery.training.messages


class MainActivity : AppCompatActivity() {


    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val mainAdapter = MainAdapter()


        bind.recyclerView.apply {
            adapter = mainAdapter
        }

        mainAdapter.submitList(messages)

    }

}