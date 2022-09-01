package com.gabriel.bible.data.remote.dto

import com.gabriel.bible.domain.model.Book

data class BookDto(
    val name: String,
    val chapters: List<String>
)

fun BookDto.toBook(): Book {
    return Book(
        name = name,
        chapters = chapters
    )
}