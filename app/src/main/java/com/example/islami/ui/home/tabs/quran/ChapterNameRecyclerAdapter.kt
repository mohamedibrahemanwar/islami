package com.example.islami.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.ItemChapterNameBinding

class ChapterNameRecyclerAdapter(val names: List<String>) :
    RecyclerView.Adapter<ChapterNameRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemChapterNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        val title: View? = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemChapterNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suras = names[position]
        holder.viewBinding.title.text = suras
        if (onItemClickedListener != null) {
            holder.viewBinding.root.setOnClickListener {
                onItemClickedListener?.onItemClick(position, suras)
            }
        }
    }

    var onItemClickedListener: OnItemClickedListener? = null

    interface OnItemClickedListener {
        fun onItemClick(position: Int, item: String)
    }
}