package com.blindfalcon.joblist.data.repos.entity

data class Vacancy(
    val id: Int,
    val clientIdVac: Int,
    val profession: String,
    val metro: List<Metro> = listOf(),
    val date: Int,
    val duties: String?,
    val conditions: String?,
    val requirements: String?,
    val client: Client?,
    val paymentFrom: Int,
    val paymentTo: Int
)