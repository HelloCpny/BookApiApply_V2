package com.example.kakaoapi_v2.data.api

import com.example.kakaoapi_v2.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//여러개의 retrofit 객체가 사용되면 통신의 혼선이 생길 수 있다.-> 싱글턴 구현 object와 lazy 사용
object RetrofitInstance {
    private val okHttpClient : OkHttpClient by lazy {  //okHttpClient객체 지연생성
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private val retrofit : Retrofit by lazy { //retrofit객체 지연생성
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create()) //DTO변환에 사용할 MOSHI CONVERTER 사용
            .client(okHttpClient) //okhttpintercpetor는 서버와 어플리케이션 사이에서 데이터를 interceptor할 수 있다.
            .baseUrl(BASE_URL)
            .build()
    }
    val api: BookSearchApi by lazy {
        retrofit.create(BookSearchApi::class.java)
    }
}