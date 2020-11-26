package com.hannah.demo.ui.add.spend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hannah.demo.R
import com.hannah.demo.database.CategoryRepository
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.utils.Constants
import kotlinx.coroutines.launch

class SpendViewModel @ViewModelInject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _categoryList = MutableLiveData<List<CategoryEntity>>()

    val categoryList: LiveData<List<CategoryEntity>> = _categoryList

    val item = MutableLiveData<CategoryEntity>()

    init {
        initCategory()
    }

    private fun initCategory(){
        viewModelScope.launch {
            getCategoryList()?.forEach {
                categoryRepository.saveCategory(it)
            }
        }
    }

    private fun getCategoryList(): List<CategoryEntity>? {
        _categoryList.value = listOf(
            CategoryEntity(name = "restaurant", type = Constants.TYPE_SPEND, icon = R.drawable.ic_menu_gallery),
            CategoryEntity(name = "transport", type = Constants.TYPE_SPEND, icon = R.drawable.ic_menu_gallery),
            CategoryEntity(name = "shopping", type = Constants.TYPE_SPEND, icon = R.drawable.ic_home_black_24dp),
            CategoryEntity(name = "clothes", type = Constants.TYPE_SPEND, icon = R.drawable.ic_menu_camera),
            CategoryEntity(name = "entertainment", type = Constants.TYPE_SPEND, icon = R.drawable.ic_menu_gallery),
            CategoryEntity(name = "snack", type = Constants.TYPE_SPEND, icon = R.drawable.ic_home_black_24dp),
        )
        return _categoryList.value
    }

}