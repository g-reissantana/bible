package com.gabriel.bible.domain.usecase

import com.gabriel.bible.data.repository.BibleRepositoryImpl
import com.gabriel.bible.domain.model.Book

class GetBooksUseCase {

    val repository = BibleRepositoryImpl()

    suspend operator fun invoke(): List<Book> {
        return repository.getBooks()
    }
}