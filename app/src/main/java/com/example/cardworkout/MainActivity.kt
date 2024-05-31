package com.example.cardworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.cardworkout.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private  var isRunning = false

    private val changeCardRunnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                changeCard()
                handler.postDelayed(this, 50)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        binding.buttonRestart.setOnClickListener {
            startChangingCard()
        }

        binding.buttonStop.setOnClickListener {
           stopChangingCard()
        }

        binding.buttonRules.setOnClickListener {
            val intent = Intent(this,RulesMainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun stopChangingCard() {
        isRunning = false
    }

    private fun startChangingCard(){
        if (!isRunning){
            isRunning = true
            handler.post(changeCardRunnable)
        }
    }

    private fun changeCard() {
        val randomCard  = Random.nextInt(1,11)
        val cardName = "card${randomCard}"
        val resId = resources.getIdentifier(cardName,"drawable",packageName)

        binding.imageView5.setImageResource(resId)
    }
}