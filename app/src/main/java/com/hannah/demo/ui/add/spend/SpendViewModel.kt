package com.hannah.demo.ui.add.spend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hannah.demo.R
import com.hannah.demo.database.CategoryRepository
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result
import com.hannah.demo.utils.Constants
import kotlinx.coroutines.launch

class SpendViewModel @ViewModelInject constructor(
    private val categoryRepository: CategoryRepository,
) : ViewModel() {

    private val _name = MutableLiveData("Ada")
    val name: LiveData<String> = _name

    val items: LiveData<List<CategoryEntity>> = categoryRepository.getCategories()

    init {
        val item = CategoryEntity(name = "new", type = Constants.TYPE_SPEND, icon = R.drawable.ic_home_black_24dp)
        viewModelScope.launch {
            categoryRepository.saveCategory(item)
        }
    }

    private fun addItems(data: List<CategoryEntity>): List<CategoryEntity> {
        val categoryToShow = ArrayList<CategoryEntity>()
        for (cate in data){
            categoryToShow.add(cate)
        }
        val item =  CategoryEntity(name = "add", type = Constants.TYPE_SPEND, icon = R.drawable.ic_menu_gallery)
        categoryToShow.add(item)
        return categoryToShow
    }


}