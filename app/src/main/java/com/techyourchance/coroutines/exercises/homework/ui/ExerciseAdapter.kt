package com.techyourchance.coroutines.exercises.homework.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techyourchance.coroutines.R

class ExerciseAdapter(private val numberList: List<String>?): RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNumber: TextView = view.findViewById(R.id.txt_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_coroutine_exercise, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNumber.text = numberList?.get(position)
    }

    override fun getItemCount(): Int = numberList?.size ?: 0

}