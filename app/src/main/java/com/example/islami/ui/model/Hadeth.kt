package com.example.islami.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hadeth(
    var title: String,
    var content: String
) : Parcelable
