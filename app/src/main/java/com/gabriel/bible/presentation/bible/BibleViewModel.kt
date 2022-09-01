package com.gabriel.bible.presentation.bible

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.bible.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.launch

class BibleViewModel: ViewModel() {

    private val _state = mutableStateOf(BibleState())
    val state: State<BibleState> = _state

    private fun getBooks() {
        viewModelScope.launch {
            val result = GetBooksUseCase()()
            _state.value = _state.value.copy(books = result)
        }
    }
}