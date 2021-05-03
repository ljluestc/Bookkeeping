package com.hannah.demo.entity

/**
 * AUTHOR: hannah
 * DATE: 2020-12-13
 */
data class AccountBook(
    val name: String,
    val list: List<ClassificationEntity> = emptyList()
)