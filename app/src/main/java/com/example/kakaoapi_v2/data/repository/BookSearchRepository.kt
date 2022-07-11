package com.example.kakaoapi_v2.data.repository

import com.example.kakaoapi_v2.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.Query

interface BookSearchRepository{
    suspend fun searchBooks(
        query: String,  //결과 문서 정렬방식 accuracy(정확도순) 또는 latest(발간일순) -> api설명서에 나와있음
        sort : String,
        page : Int,
        size : Int
    ) : Response<SearchResponse>
}