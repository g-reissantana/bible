package com.gabriel.bible.data.repository

import com.gabriel.bible.data.remote.BibleApi
import com.gabriel.bible.data.remote.dto.toBook
import com.gabriel.bible.domain.model.Book
import com.gabriel.bible.domain.repository.BibleRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class BibleRepositoryImpl : BibleRepository {

    private val api = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create<BibleApi>()

    override suspend fun getBooks(): List<Book> {
        val response = api.getBooks()
        return response.map { it.toBook() }
    }

    override fun getChapter(bookId: String, chapterId: String): List<String> {
        return emptyList()
    }
}