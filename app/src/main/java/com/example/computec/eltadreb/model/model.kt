package com.example.computec.eltadreb.model

import com.google.gson.annotations.SerializedName

data class Student(var id: Int, var name: String, var phone: String, var picture: String?
                   , @SerializedName("academic_year_vis") var academicYear: String
                   , @SerializedName("academic_division") var academicDivision: String, var school: School)

data class School(var id: Int, var name: String, var address: String, var phone: String)

data class Category(@SerializedName("name_vis") var name: String, var courses: MutableList<Course>)

data class Course(var id: Int, var name: String, var cover: String?, var videos: MutableList<Video>?)

data class Video(var id: Int, var title: String, var description: String?, var video: String?
                 , var thumb: String, var comments: MutableList<Comment>?)

data class Comment(var id: Int? = 0, var content: String
                   , @SerializedName("created_at_vis") var createdAt: String? = null
                   , var author: Student? = null, @SerializedName("replies_count") var repliesN: Int = 0
                   , var replies: MutableList<Comment>? = null)