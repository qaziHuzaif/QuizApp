package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.quizapp.data.Constants
import com.example.quizapp.data.Question
import java.util.ArrayList

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var selectedOptionPosition: Int = 0

    private var username = "username"

    private var correctAnswers = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null

    private var questionList: ArrayList<Question> = ArrayList<Question>()
    private var currentQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_quiz_questions)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        username = intent.getStringExtra(Constants.USER_NAME).toString()

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        tvOption1 = findViewById(R.id.tvOption1)
        tvOption2 = findViewById(R.id.tvOption2)
        tvOption3 = findViewById(R.id.tvOption3)
        tvOption4 = findViewById(R.id.tvOption4)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        questionList = Constants.getQuestion()

        progressBar?.max = questionList.size

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        progressBar?.progress = currentQuestion + 1
        tvProgress?.text = "${currentQuestion + 1}/${questionList.size}"
        tvQuestion?.text = questionList[currentQuestion].question
        ivImage?.let { Glide.with(this).load(questionList[currentQuestion].image).into(it) }
        tvOption1?.text = questionList[currentQuestion].option1
        tvOption2?.text = questionList[currentQuestion].option2
        tvOption3?.text = questionList[currentQuestion].option3
        tvOption4?.text = questionList[currentQuestion].option4
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        tvOption1?.let {
            options.add(0, it)
        }
        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#FFFFFF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_button_bg)
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#FF000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_button_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOption1 -> {
                if (btnSubmit?.text == getString(R.string.submit)) {
                    tvOption1?.let { selectedOptionView(it, 1) }
                }
            }

            R.id.tvOption2 -> {
                if (btnSubmit?.text == getString(R.string.submit)) {
                    tvOption2?.let { selectedOptionView(it, 2) }
                }
            }

            R.id.tvOption3 -> {
                if (btnSubmit?.text == getString(R.string.submit)) {
                    tvOption3?.let { selectedOptionView(it, 3) }
                }
            }

            R.id.tvOption4 -> {
                if (btnSubmit?.text == getString(R.string.submit)) {
                    tvOption4?.let { selectedOptionView(it, 4) }
                }
            }

            R.id.btnSubmit -> {
                if (selectedOptionPosition == 0 && btnSubmit?.text != getString(R.string.submit)) {
                    currentQuestion++
                    when {
                        currentQuestion < questionList.size -> {
                            btnSubmit?.text = getString(R.string.submit)
                            setQuestion()
                        }

                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, username)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionList.size.toString())
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers.toString())
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionList[currentQuestion]
                    if (question.correctOption != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.incorrect_option_button_bg)
                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_button_bg)
                    if (currentQuestion == questionList.size - 1) {
                        btnSubmit?.text = getString(R.string.finish)
                    } else {
                        btnSubmit?.text = getString(R.string.go_to_next_question)
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(this, drawableView)
                tvOption1?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }

            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(this, drawableView)
                tvOption2?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }

            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(this, drawableView)
                tvOption3?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }

            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(this, drawableView)
                tvOption4?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }
    }
}