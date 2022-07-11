package com.example.kakaoapi_v2.util

import com.example.kakaoapi_v2.BuildConfig

//requeest 요청에 사용할 url 과 api key정보를 보관
object Constants { //request 요청이 중복되지 않게 object로 사용
    const val BASE_URL = "https://dapi.kakao.com/"
    const val API_KEY = BuildConfig.bookApiKey
    const val SEARCH_BOOKS_TIME_DELAY = 100L
    //모든 사람이 볼 수 있으므로 안전하지 않은 방식이다. -> local property에 키를 넣어 사용
    //Secret Gradle Plugin for android에 대한 gradle 추가하여 사용
    // const val API_KEY = "32803cba2b1a0296a3745b15f02ba28"
}