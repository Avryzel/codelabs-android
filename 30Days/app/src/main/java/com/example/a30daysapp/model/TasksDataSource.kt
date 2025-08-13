package com.example.a30daysapp.model

import com.example.a30daysapp.R

object TasksDataSource {
    val tasks = listOf(
        Task(
            dayRes = R.string.day_1_number,
            imageRes = R.drawable.ic_day1_book_kanji,
            titleRes = R.string.day_1_title,
            descriptionRes = R.string.day_1_descriptions
        ),
        Task(
            dayRes = R.string.day_2_title,
            imageRes = R.drawable.ic_day1_book_kanji,
            titleRes = R.string.day_2_title,
            descriptionRes = R.string.day_2_descriptions
        )
    )
}