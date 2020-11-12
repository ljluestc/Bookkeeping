package com.hannah.demo.ui.add.spend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hannah.demo.database.CategoryRepository
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result
import kotlinx.coroutines.launch

class SpendViewModel @ViewModelInject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

//    val items: LiveData<List<CategoryEntity>> = _items

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

    fun initCategory(){
        viewModelScope.launch {
//            categoryRepository.saveCategory(CategoryEntity(name = "other",icon = ))
        }
    }


}