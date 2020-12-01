package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result


/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
interface CategoryDataSource {

    fun observeCategories(): LiveData<List<CategoryEntity>>

    fun getCategories(): LiveData<List<CategoryEntity>>

    suspend fun saveCategory(item: CategoryEntity)

    suspend fun selectedCategory(category: CategoryEntity)

    suspend fun unSelectedCategory(unSelected: CategoryEntity)

    suspend fun getCategoryById(id: Long): Result<CategoryEntity>

    suspend fun deleteAllCategories()

    suspend fun deleteCategoryById(categoryId: Long)

}