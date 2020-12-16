package com.willshuffyproject.githubusers_bfaasubmission2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class UserData  (

    val username: String?= null,
    val name: String?= null,
    val profpict: String?= null,
    val company: String?= null,
    val location: String?= null,
    val repository: String?= null,
    val follower: String?= null,
    val following: String?= null

): Parcelable