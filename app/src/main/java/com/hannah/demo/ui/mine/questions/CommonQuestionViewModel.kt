package com.hannah.demo.ui.mine.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.entity.QuestionEntity
import com.hannah.demo.entity.QuestionRepository

class CommonQuestionViewModel : ViewModel() {

    private val repository = QuestionRepository()

    private val _questions = MutableLiveData<List<QuestionEntity>>()
    val questions: LiveData<List<QuestionEntity>> = _questions

    init {
        _questions.value = repository.getQuestions()
    }

    fun clickQuestionItem(question: QuestionEntity){
        val questionLocal = _questions.value?.toMutableList() ?: mutableListOf()

        val closeIndex = questionLocal.indexOfFirst { it.expanded }
        if(closeIndex > -1){
            questionLocal[closeIndex] = questionLocal[closeIndex].copy(expanded = false)
        }
        val isGoingToOpen = !question.expanded
        if(isGoingToOpen){
            val openIndex = _questions.value?.indexOf(question)
            if (openIndex != null && openIndex > -1) {
                questionLocal[openIndex] = question.copy(expanded = true)
            }
        }
        this._questions.value = questionLocal
    }

}