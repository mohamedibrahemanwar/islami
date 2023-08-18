package com.example.islami.ui.home.tabs.hadeth

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.ui.model.Hadeth

class AhadethRecyclerAdapter(var ahdethList: List<Hadeth>?) :
    RecyclerView.Adapter<AhadethRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemHadethBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = ahdethList?.size ?: 0

    @SuppressLint("NotifyDataSetChanged")
    fun bindItems(newList: List<Hadeth>) {
        ahdethList = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.title.text = ahdethList!![position].title
        if (onHadethClickListneer != null) {
            holder.binding.title.setOnClickListener {
                onHadethClickListneer?.onClick(
                    position,
                    ahdethList!![position]
                )
            }
        }
    }

    var onHadethClickListneer: OnHadethClickListneer? = null

    fun interface OnHadethClickListneer {
        fun onClick(position: Int, item: Hadeth)
    }
}