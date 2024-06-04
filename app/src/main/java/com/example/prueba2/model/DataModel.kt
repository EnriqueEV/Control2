package com.example.prueba2.model

import kotlinx.serialization.Serializable
@Serializable
data class Facts(
    val categories: List<Any>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String
)
@Serializable
data class FactsQuery(
    val result: List<Facts>,
    val total: Int
)