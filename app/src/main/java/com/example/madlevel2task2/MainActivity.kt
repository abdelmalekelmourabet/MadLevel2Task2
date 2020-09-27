package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val questions = arrayListOf<Questions>()
    private val questionAdapter = QuestionsAdapter(questions)
    private var incorrectAnswer = R.string.incorrect;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        // Initialize the recycler view
        binding.rvQuestions.layoutManager = LinearLayoutManager(
            this@MainActivity, RecyclerView.VERTICAL, false
        )
        binding.rvQuestions.adapter = questionAdapter
        binding.rvQuestions.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL
            )
        )

        for (i in Questions.List_Questions.indices) {
            questions.add(Questions(Questions.List_Questions[i], Questions.List_Answers[i]))
        }

        createItemTouchHelper().attachToRecyclerView(binding.rvQuestions)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val selectedQuestions: Questions = questions[position]

                if (direction == ItemTouchHelper.RIGHT && selectedQuestions.answers ||
                    direction == ItemTouchHelper.LEFT && !selectedQuestions.answers
                ) {
                    questions.removeAt(position)
                } else {
                    Snackbar.make(
                        binding.llmessage, incorrectAnswer, Snackbar.LENGTH_LONG
                    ).show()
                }
                questionAdapter.notifyDataSetChanged()
            }

        }

        return ItemTouchHelper(callback)
    }
}