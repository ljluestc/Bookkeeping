package com.hannah.demo.entity

/**
 * AUTHOR: hannah
 * DATE: 07/01/21
 */
data class QuestionEntity(
    val id: Int,
    val question: String,
    val answer: String,
    val expanded: Boolean = false
)