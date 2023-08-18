package com.example.islami.ui.home.tabs.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.ui.Constant
import com.example.islami.ui.hadethdeatils.hadethDetails
import com.example.islami.ui.model.Hadeth

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
    }

    lateinit var adapter: AhadethRecyclerAdapter
    fun initRecycler() {
        adapter = AhadethRecyclerAdapter(null)
        adapter.onHadethClickListneer = object : AhadethRecyclerAdapter.OnHadethClickListneer {
            override fun onClick(position: Int, item: Hadeth) {
                showHadethDetails(item)
            }

        }
        viewBinding.contentHadeth.ahadethRecycler.adapter = adapter

    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity, hadethDetails::class.java)
        intent.putExtra(Constant.EXTRA_KEY_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        loadFiles()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindItems(hadethList)
    }

    var hadethList = mutableListOf<Hadeth>()
    private fun loadFiles() {
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        var singlehadethList = fileContent.trim().split("#")
        singlehadethList.forEach {
            val lines = it.trim().split("\n")
            val titls = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(titls, content)
            hadethList.add(hadeth)
        }
    }


}