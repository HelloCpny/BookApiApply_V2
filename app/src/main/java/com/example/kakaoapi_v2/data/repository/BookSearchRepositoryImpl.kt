package com.example.kakaoapi_v2.data.repository

import com.example.kakaoapi_v2.data.api.RetrofitInstance.api
import com.example.kakaoapi_v2.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl :BookSearchRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }
}