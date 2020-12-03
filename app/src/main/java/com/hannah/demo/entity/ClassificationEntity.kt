package com.hannah.demo.entity

/**
 * AUTHOR: hannah
 * DATE: 2020-12-02
 */
data class ClassificationEntity(
    val id: Int? = 0,
    val title: String,
    val categories: List<CategoryEntity> = emptyList()
)