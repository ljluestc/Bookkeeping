package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.entity.CategoryEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */

interface CategoryRepository {

    fun observeCategories(): LiveData<List<CategoryEntity>>

    fun refreshTasks()

    fun getCategories(): LiveData<List<CategoryEntity>>

    suspend fun saveCategory(item: CategoryEntity)

    suspend fun selectedCategory(selectedCategory: CategoryEntity)

    suspend fun deleteAllCategories()

    suspend fun deleteCategoryById(categoryId: Long): Int

}