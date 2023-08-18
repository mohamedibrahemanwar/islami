package com.example.islami.ui.hadethdeatils

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.ui.Constant
import com.example.islami.ui.model.Hadeth

class hadethDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initviews()
        initprams()
        bindHadeth()
    }

    private fun initviews() {
        setSupportActionBar(viewBinding.hadethToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBinding.hadethTitle.text = hadeth?.title
        viewBinding.contentHadethDet.txtContentHadeth.text = hadeth?.content
    }

    var hadeth: Hadeth? = null
    private fun initprams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constant.EXTRA_KEY_HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getParcelableExtra(Constant.EXTRA_KEY_HADETH) as Hadeth?
        }
    }
}