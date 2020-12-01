package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result
import kotlinx.coroutines.*

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

    override suspend fun selectedCategory(selectedCategory: CategoryEntity) {
        withContext(ioDispatcher) {
            (getCategoryWithId(selectedCategory.id) as? Result.Success)?.let { selectedCategory->

                coroutineScope {
                    launch {
                        categoryLocalDataSource.selectedCategory(selectedCategory.data)
//                        categoryLocalDataSource.getCategories().value?.forEach { item ->
//                            if (selectedCategory.data == item){
//
//                            }else{
//                                categoryLocalDataSource.unSelectedCategory(item)
//                            }
//                        }
                    }
                }
            }
        }
    }

    override suspend fun deleteAllCategories() {
        coroutineScope {
            launch {
                categoryLocalDataSource.deleteAllCategories()
            }
        }
    }

    override suspend fun deleteCategoryById(categoryId: Long): Int {
        coroutineScope {
            launch {
                categoryLocalDataSource.deleteCategoryById(categoryId)
            }
            return@coroutineScope 1
        }
      return -1
    }

    private suspend fun getCategoryWithId(id: Long): Result<CategoryEntity> {
        return categoryLocalDataSource.getCategoryById(id)
    }

}