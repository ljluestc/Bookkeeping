package com.hannah.demo.ui.add.spend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hannah.demo.database.CategoryRepository
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result
import com.hannah.demo.utils.Constants
import kotlinx.coroutines.launch

class SpendViewModel @ViewModelInject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    val categoryList = MutableLiveData<List<CategoryEntity>>()

//    private val _items: LiveData<List<CategoryEntity>> =


    //    private val _index = MutableLiveData<Int>()
//    val text: LiveData<String> = Transformations.map(_index) {
//        "Hello world from section: $it"
//    }
//
//    fun setIndex(index: Int) {
//        _index.value = index
//    }
//    fun getCategory() : Result<List<CategoryEntity>> {
//        viewModelScope.launch {
//             categoryRepository.getCategories()
//        }
//    }

    init {
        initCategory()
    }

    fun initCategory(){
        viewModelScope.launch {
            getCategoryList()?.forEach {
                categoryRepository.saveCategory(it)
            }
        }
    }

    private fun getCategoryList(): List<CategoryEntity>? {
        categoryList.value = listOf(
            CategoryEntity(name = "restaurant", type = Constants.TYPE_SPEND),
            CategoryEntity(name = "restaurant", type = Constants.TYPE_SPEND),
            CategoryEntity(name = "restaurant", type = Constants.TYPE_SPEND),
            CategoryEntity(name = "restaurant", type = Constants.TYPE_SPEND),
        )
        return categoryList.value
    }


}