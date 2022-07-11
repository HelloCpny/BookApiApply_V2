package com.example.kakaoapi_v2.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
//moshi
//Json object에 대응되는 역할을 한다. generateAdapter을 true로 해주어야 codegen방식으로 직렬화 역직렬화가 가능
//codegen? : 자동으로 code를 생성해 내는 것을 말함
@JsonClass(generateAdapter = true)
data class Book(
    @field:Json(name = "authors") //@Json annotation은 @Json만으로는 kotlin변환에 실패하기   때문에 오류 방지위해 'field:' 추가
    val authors: List<String>, //도서 저자 리스트
    @field:Json(name = "contents")
    val contents: String,//도서 소개
    @field:Json(name = "datetime")
    val datetime: String,//도서 출판날짜 [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
    @field:Json(name = "isbn")
    val isbn: String, //국제 표준 도서번호
    @field:Json(name = "price")
    val price: Int, //도서 정가
    @field:Json(name = "publisher")
    val publisher: String, //도서 출판사
    @field:Json(name = "sale_price")
    val salePrice: Int, //도서 판매가
    @field:Json(name = "status")
    val status: String, //도서 판매 상태 정보
    @field:Json(name = "thumbnail")
    val thumbnail: String, //도서 표지 미리보기 URL
    @field:Json(name = "title")
    val title: String, //도서 제목
    @field:Json(name = "translators")
    val translators: List<String>, // 도서 번역자 리스트
    @field:Json(name = "url")
    val url: String //도서 상세 URL
)