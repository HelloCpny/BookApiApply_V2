package com.example.kakaoapi_v2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kakaoapi_v2.data.repository.BookSearchRepository

@Suppress("UNCHECKED_CAST")
class BookSearchVIewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}