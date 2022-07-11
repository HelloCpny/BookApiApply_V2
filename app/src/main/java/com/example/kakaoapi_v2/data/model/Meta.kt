package com.example.kakaoapi_v2.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @field:Json(name = "is_end")
    val isEnd: Boolean, //현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음페이지 요청
    @field:Json(name = "pageable_count")
    val pageableCount: Int, //중복된 문서를 제외하고, 처음부터 요청 페이지까지의 노출 가능 문서 수
    @field:Json(name = "total_count")
    val totalCount: Int //검색된 문서 수
)