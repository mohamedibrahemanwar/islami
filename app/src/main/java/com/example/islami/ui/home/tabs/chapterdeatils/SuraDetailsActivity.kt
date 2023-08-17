package com.example.islami.ui.home.tabs.chapterdeatils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivitySuraDetailsBinding
import com.example.islami.ui.home.tabs.Constant

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initparms()
        loadChapterFile()
        initViews()
    }

    private fun initViews() {
        viewBinding.suraTitle.text = chapterName
        setSupportActionBar(viewBinding.suraToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun loadChapterFile() {
        var fileContent = assets.open("$indexofSura.txt").bufferedReader().use {
            it.readText()
        }
        var lines = fileContent.trim().split("\n")
        bindVeeses(lines)

    }

    lateinit var adapter: suraAdapter
    private fun bindVeeses(verses: List<String>) {
        adapter = suraAdapter(verses)
        viewBinding.contentSuraDet.recyclerViewSura.adapter = adapter
    }

    var indexofSura: Int = 0
    lateinit var chapterName: String
    private fun initparms() {
        indexofSura = intent.getIntExtra(Constant.EXTRA_KEY_INDEX, 0)
        chapterName = intent.getStringExtra(Constant.EXTRA_KEY_NAME) ?: ""
    }
}