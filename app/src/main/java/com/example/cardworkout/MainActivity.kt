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

    private val cardList = listOf(R.drawable.card1,
        R.drawable.card2,
        R.drawable.card4,
        R.drawable.card5,
        R.drawable.card6,
        R.drawable.card7,
        R.drawable.card8,
        R.drawable.card9,
        R.drawable.card10)

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
            binding.buttonRestart.text = "Restart"
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
            changeCard()
            handler.post(changeCardRunnable)
        }
    }

    private fun changeCard() {
        val randomCard  = Random.nextInt(cardList.size)
        val resId = cardList[randomCard]
        binding.imageView5.setImageResource(resId)
    }
}