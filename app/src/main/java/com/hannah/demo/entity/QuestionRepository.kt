package com.hannah.demo.entity

/**
 * AUTHOR: hannah
 * DATE: 07/01/21
 */
class QuestionRepository {

    fun getQuestions(): List<QuestionEntity> {
        return listOf(
            QuestionEntity(
                id = 1,
                question = "How to make a quick item",
                answer = "On the bookkeeping page, click the plus sign to keep accounts quickly",
                expanded = false
            ),
            QuestionEntity(
                id = 2,
                question = "How to modify the bookkeeping flow",
                answer = "On the accounting page, click Edit to modify it",
                expanded = false
            ),
            QuestionEntity(
                id = 3,
                question = "How to switch between account books",
                answer = "On the accounting page, click Edit to modify it",
                expanded = false
            ),
            QuestionEntity(
                id = 4,
                question = "What do you think of chart statistics?",
                answer = "On the bookkeeping page, click the chart to view the distribution of income and expenditure in different categories in different periods of time",
                expanded = false
            ),
        )
    }
}