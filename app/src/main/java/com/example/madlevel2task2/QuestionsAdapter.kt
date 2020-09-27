package com.example.madlevel2task2

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ItemQuestionBinding

class QuestionsAdapter(private val questions: List<Questions>) :
    RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemQuestionBinding.bind(itemView)

        fun databind(questions: Questions) {
            binding.tvQuestions.text = questions.questions
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(questions[position])
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}