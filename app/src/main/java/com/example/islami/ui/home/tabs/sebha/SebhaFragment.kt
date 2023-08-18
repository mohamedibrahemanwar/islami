package com.example.islami.ui.home.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    var angle = 0
    var count = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sebhaClick()
    }

    private fun sebhaClick() {
        viewBinding.contentSebha.sebhaAction.setOnClickListener {
            angle += 1;
            viewBinding.contentSebha.sebhaImage.setRotation(angle.toFloat());
            viewBinding.contentSebha.sebhaCount.text = count.toString()
            count++
        }
    }
}