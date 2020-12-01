package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.entity.CategoryEntity


/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
interface CategoryDataSource {

    fun observeCategories(): LiveData<List<CategoryEntity>>

    fun getCategories(): LiveData<List<CategoryEntity>>

    suspend fun saveCategory(item: CategoryEntity)

}