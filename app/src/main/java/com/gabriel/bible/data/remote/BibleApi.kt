package com.gabriel.bible.data.remote

import com.gabriel.bible.data.remote.dto.BookDto
import retrofit2.http.GET

interface BibleApi {

    @GET("books")
    suspend fun getBooks(): List<BookDto>

}