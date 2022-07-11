package com.example.kakaoapi_v2.data.api

import com.example.kakaoapi_v2.data.model.SearchResponse
import com.example.kakaoapi_v2.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//retrofit에 필요한 서비스를 만드는 곳
//ApiKey와 인자를 전달받아 BookApi에 get요청을 수행하는 서비스
interface  BookSearchApi {
    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("/v3/search/book")
    //파라미터 작성
    //parameter - 매개변수 (입력 변수)  * argument = 전달인자, 인자 (입력값)
    suspend fun searchBooks(
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Response<SearchResponse>  //Retrofit의 Response
}