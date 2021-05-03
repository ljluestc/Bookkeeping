package com.hannah.demo.ui.classification

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hannah.demo.R
import com.hannah.demo.entity.AccountBook
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.ClassificationEntity
import com.hannah.demo.entity.Event

/**
 * AUTHOR: hannah
 * DATE: 2020-12-01
 */
class AddNewClassificationViewModel @ViewModelInject constructor() : ViewModel() {

    private val _books = MutableLiveData<List<AccountBook>>()
    val books: LiveData<List<AccountBook>> = _books

//    private val _classifications = MutableLiveData<List<ClassificationEntity>>()
//    val classifications: LiveData<List<ClassificationEntity>> = _classifications

    private val _childListData = MutableLiveData<List<CategoryEntity>>()
    val childListData: LiveData<List<CategoryEntity>> = _childListData

    private val _clickBookItemEvent = MutableLiveData<Event<AccountBook>>()
    val clickBookItemEvent: LiveData<Event<AccountBook>> = _clickBookItemEvent


    init {
        _books.value = addBookData()
//        _classifications.value = addClassificationData("DAILY")
    }

    private fun addClassificationData(name: String): List<ClassificationEntity> {
       return when(name){
            "DAILY" -> listOf(
                ClassificationEntity(
                    title = "FOOD", categories = listOf(
                        CategoryEntity(name = "sandwich", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "bread", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera)
                    )
                ),
                ClassificationEntity(
                    title = "Entertainment", categories = listOf(
                        CategoryEntity(name = "sing", icon = R.drawable.ic_menu_gallery),
                        CategoryEntity(name = "running", icon = R.drawable.ic_menu_gallery),
                        CategoryEntity(name = "running", icon = R.drawable.ic_menu_gallery),
                        CategoryEntity(name = "talking", icon = R.drawable.ic_menu_gallery)
                    )
                ),
                ClassificationEntity(
                    title = "FOOD", categories = listOf(
                        CategoryEntity(name = "sandwich", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "bread", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "bread", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera)
                    )
                ),)
            "CHILD" -> listOf(
                ClassificationEntity(
                    title = "Tool", categories = listOf(
                        CategoryEntity(name = "sandwich", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "bread", icon = R.drawable.ic_menu_camera),
                        CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera)
                    )
                ),)
           "BUSINESS" -> listOf(
               ClassificationEntity(
                   title = "Pay", categories = listOf(
                       CategoryEntity(name = "training", icon = R.drawable.ic_menu_gallery),
                       CategoryEntity(name = "office", icon = R.drawable.ic_menu_gallery),
                       CategoryEntity(name = "tax", icon = R.drawable.ic_menu_gallery),
                       CategoryEntity(name = "maintain", icon = R.drawable.ic_menu_gallery)
                   )
               ),
               ClassificationEntity(
                   title = "FOOD", categories = listOf(
                       CategoryEntity(name = "sandwich", icon = R.drawable.ic_menu_camera),
                       CategoryEntity(name = "bread", icon = R.drawable.ic_menu_camera),
                       CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera),
                       CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera)
                   )
               ),)
           "TRAVEL" -> listOf(
               ClassificationEntity(
                   title = "Transportation", categories = listOf(
                       CategoryEntity(name = "subway", icon = R.drawable.ic_menu_camera),
                       CategoryEntity(name = "taxi", icon = R.drawable.ic_menu_camera),
                       CategoryEntity(name = "plane", icon = R.drawable.ic_menu_camera),
                       CategoryEntity(name = "car", icon = R.drawable.ic_menu_camera)
                   )
               ),
               ClassificationEntity(
                   title = "Flight", categories = listOf(
                       CategoryEntity(name = "sing", icon = R.drawable.ic_menu_gallery),
                       CategoryEntity(name = "running", icon = R.drawable.ic_menu_gallery),
                       CategoryEntity(name = "talking", icon = R.drawable.ic_menu_gallery)
                   )
               ),)
           else -> emptyList()
        }
    }

    private fun addBookData(): List<AccountBook> {
        return listOf<AccountBook>(
            AccountBook("DAILY", addClassificationData("DAILY")),
            AccountBook("CHILD", addClassificationData("CHILD")),
            AccountBook("BUSINESS", addClassificationData("BUSINESS")),
            AccountBook("TRAVEL", addClassificationData("TRAVEL")),
        )
    }

    fun clickBookItem(bookName: AccountBook) {
        _clickBookItemEvent.value = Event(bookName)
//        v.setBackgroundColor(R.color.white)
    }
}