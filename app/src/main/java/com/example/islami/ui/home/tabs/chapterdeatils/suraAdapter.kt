package com.example.islami.ui.home.tabs.chapterdeatils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemSuraBinding

class suraAdapter(var versesList: List<String>) : RecyclerView.Adapter<suraAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemSuraBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSuraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = versesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contentSura.text = versesList[position]
    }
}