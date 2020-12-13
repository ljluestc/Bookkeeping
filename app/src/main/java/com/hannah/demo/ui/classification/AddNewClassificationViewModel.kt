package com.hannah.demo.ui.classification

import android.annotation.SuppressLint
import android.widget.TextView
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

    private val _classifications = MutableLiveData<List<ClassificationEntity>>()
    val classifications: LiveData<List<ClassificationEntity>> = _classifications

    private val _childListData = MutableLiveData<List<CategoryEntity>>()
    val childListData: LiveData<List<CategoryEntity>> = _childListData

    private val _clickBookItemEvent = MutableLiveData<Event<AccountBook>>()
    val clickBookItemEvent: LiveData<Event<AccountBook>> = _clickBookItemEvent


    init {
        _books.value = addBookData()
        _classifications.value = addClassificationData()
    }

    private fun addClassificationData(): List<ClassificationEntity> {
        return listOf(
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
                    CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera),
                    CategoryEntity(name = "butter", icon = R.drawable.ic_menu_camera)
                )
            ),
            ClassificationEntity(
                title = "Entertainment", categories = listOf(
                    CategoryEntity(name = "sing", icon = R.drawable.ic_menu_gallery),
                    CategoryEntity(name = "running", icon = R.drawable.ic_menu_gallery),
                    CategoryEntity(name = "talking", icon = R.drawable.ic_menu_gallery)
                )
            )
        )
    }

    private fun addBookData(): List<AccountBook> {
        return listOf<AccountBook>(
            AccountBook.DAILY,
            AccountBook.CHILD,
            AccountBook.BUSINESS,
            AccountBook.TRAVEL
        )
    }

    fun clickBookItem(bookName: AccountBook) {
        _clickBookItemEvent.value = Event(bookName)
//        v.setBackgroundColor(R.color.white)
    }
}