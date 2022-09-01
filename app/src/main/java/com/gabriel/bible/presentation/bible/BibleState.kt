package com.gabriel.bible.presentation.bible

import com.gabriel.bible.domain.model.Book

data class BibleState(
    val isLoading: Boolean = false,
    val error: String = "",
    val books: List<Book> = emptyList()
)
