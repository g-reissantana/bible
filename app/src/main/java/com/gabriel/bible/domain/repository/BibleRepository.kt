package com.gabriel.bible.domain.repository

import com.gabriel.bible.domain.model.Book

interface BibleRepository {

    suspend fun getBooks(): List<Book>
    fun getChapter(bookId: String, chapterId: String): List<String>

}