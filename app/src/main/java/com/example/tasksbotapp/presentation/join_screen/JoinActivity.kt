package com.example.tasksbotapp.presentation.join_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksbotapp.databinding.ActivityJoinBinding
import com.example.tasksbotapp.presentation.asks_screen.AsksActivity

class JoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityJoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, AsksActivity::class.java)
            intent.putExtra("room", binding.userNameText.text.toString())
            startActivity(intent)
        }

    }
}