package com.example.kakaoapi_v2.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaoapi_v2.data.model.SearchResponse
import com.example.kakaoapi_v2.data.repository.BookSearchRepository
import com.example.kakaoapi_v2.data.repository.BookSearchRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Query

class BookSearchViewModel(
    private val bookSearchRespository : BookSearchRepository
) : ViewModel() {
    //Api
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult : LiveData<SearchResponse> get() = _searchResult

    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = bookSearchRespository.searchBooks(query,"accuracy",1,15)
        if (response.isSuccessful){
            response.body()?.let { body ->
                _searchResult.postValue(body)
            }
        }
    }
}