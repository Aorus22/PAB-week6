package com.example.ppab_06_l0122018

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable