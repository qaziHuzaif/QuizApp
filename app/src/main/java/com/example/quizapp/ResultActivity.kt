package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.data.Constants

class ResultActivity : AppCompatActivity() {
    private var username = "User"
    private var totalQuestions = "0"
    private var correctAnswers = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_result)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = intent.getStringExtra(Constants.USER_NAME).toString()
        totalQuestions = intent.getStringExtra(Constants.TOTAL_QUESTIONS).toString()
        correctAnswers = intent.getStringExtra(Constants.CORRECT_ANSWERS).toString()

        val btnFinish: Button = findViewById(R.id.btnFinish)
        val tvUsername: TextView = findViewById(R.id.tvUsername)
        val tvResult: TextView = findViewById(R.id.tvResult)

        tvUsername.text = username
        tvResult.text = getString(R.string.you_scored_out_of, correctAnswers, totalQuestions)

        btnFinish.setOnClickListener{
            finish()
        }
    }
}