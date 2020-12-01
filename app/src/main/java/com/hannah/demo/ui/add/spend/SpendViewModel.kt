package com.hannah.demo.ui.add.spend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hannah.demo.R
import com.hannah.demo.database.CategoryRepository
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Event
import com.hannah.demo.utils.Constants
import kotlinx.coroutines.launch

class SpendViewModel @ViewModelInject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _name = MutableLiveData("Other")
    val name: LiveData<String> = _name

    private val _icon = MutableLiveData(R.drawable.ic_home_black_24dp)
    val icon: LiveData<Int> = _icon

    private val _isItemChecked = MutableLiveData(false)
    val isItemChecked: LiveData<Boolean> = _isItemChecked

    private val _clickCategoryItemEvent = MutableLiveData<Event<CategoryEntity>>()
    val clickCategoryItemEvent: LiveData<Event<CategoryEntity>> = _clickCategoryItemEvent

    private val _clickAddItemEvent = MutableLiveData<Event<Unit>>()
    val clickAddItemEvent: LiveData<Event<Unit>> = _clickAddItemEvent

    val items: LiveData<List<CategoryEntity>> = categoryRepository.getCategories()

    init {
        val item = CategoryEntity(name = "new", type = Constants.TYPE_SPEND, icon = R.drawable.ic_home_black_24dp)
        viewModelScope.launch {
            categoryRepository.deleteAllCategories()
            categoryRepository.saveCategory(item)
        }
    }

    fun clickCategoryItem(category: CategoryEntity) {
        _clickCategoryItemEvent.value = Event(category)
        _name.value = category.name
        _icon.value = category.icon

        viewModelScope.launch {
            categoryRepository.selectedCategory(category)
        }
    }

    fun addNewTask() {
        _clickAddItemEvent.value = Event(Unit)
    }
}