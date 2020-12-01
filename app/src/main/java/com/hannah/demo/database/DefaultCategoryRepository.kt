package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.entity.CategoryEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
class DefaultCategoryRepository(
    private val categoryLocalDataSource: CategoryDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CategoryRepository {

    override fun observeCategories(): LiveData<List<CategoryEntity>> {
        return categoryLocalDataSource.observeCategories()
    }

    override fun refreshTasks() {
        categoryLocalDataSource.getCategories()
    }

    override fun getCategories(): LiveData<List<CategoryEntity>> {
        return categoryLocalDataSource.getCategories()
    }

    override suspend fun saveCategory(item: CategoryEntity) {
        coroutineScope {
            launch {
                categoryLocalDataSource.saveCategory(item)
            }
        }
    }

}