package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result


/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
interface CategoryDataSource {

    fun observeCategories(): LiveData<Result<List<CategoryEntity>>>

    suspend fun getCategories(): Result<List<CategoryEntity>>

    suspend fun saveCategory(item: CategoryEntity)

}