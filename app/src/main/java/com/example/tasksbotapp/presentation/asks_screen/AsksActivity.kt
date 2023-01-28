package com.example.tasksbotapp.presentation.asks_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasksbotapp.data.firebaseRepository.UserAsksFirebase
import com.example.tasksbotapp.databinding.ActivityMainBinding
import com.example.tasksbotapp.domain.use_cases.GetAsks
import com.example.tasksbotapp.domain.use_cases.RemoveAsks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AsksActivity : AppCompatActivity() {
    lateinit var adapter: AsksListAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getRoomName = intent.getStringExtra("room").toString()

        val getAsksUseCase = GetAsks(UserAsksFirebase(getRoomName))
        val removeAsksUseCase = RemoveAsks(UserAsksFirebase(getRoomName))

        adapter = AsksListAdapter()
        CoroutineScope(Dispatchers.Unconfined).launch {
            getAsksUseCase.execute(adapter)
            binding.rec.layoutManager = LinearLayoutManager(applicationContext)
            binding.rec.adapter = adapter
        }

        binding.floatingActionButton2.setOnClickListener {
            removeAsksUseCase.execute()
            startActivity(Intent(this, this::class.java))
        }

    }
}
