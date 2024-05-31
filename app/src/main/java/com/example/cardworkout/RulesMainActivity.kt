package com.example.cardworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardworkout.databinding.ActivityRulesMainBinding

class RulesMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRulesMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goBackClickListener()
    }
    private fun goBackClickListener(){
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}