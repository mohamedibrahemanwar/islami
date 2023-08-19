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
    var count = 1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sebhaClick()
    }

    private fun sebhaClick() {
        viewBinding.contentSebha.sebhaAction.setOnClickListener {
            angle += 1;
            viewBinding.contentSebha.sebhaImage.setRotation(angle.toFloat());
            if (count == 33) {
                viewBinding.contentSebha.sebhaAction.text = "الحمدلله"
            } else if (count == 66) {
                viewBinding.contentSebha.sebhaAction.text = "الله اكبر"
            } else if (count == 99) {
                viewBinding.contentSebha.sebhaAction.text =
                    " لا إله إلا الله، وحده لا شريك له، له الملك، وله الحمد، وهو على كل شيء قدير"
            } else if (count == 100) {
                viewBinding.contentSebha.sebhaAction.text = "سبحان الله"
            }
            viewBinding.contentSebha.sebhaCount.text = count.toString()
            count++

        }

    }
}