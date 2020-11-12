package com.hannah.demo.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
class CategoryLocalDataSource (
    private val categoryDAO: CategoryDAO,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CategoryDataSource {

    override fun observeCategories(): LiveData<Result<List<CategoryEntity>>> {
        return categoryDAO.observeCategories().map {
            Result.Success(it)
        }
    }

    override suspend fun getCategories(): Result<List<CategoryEntity>> = withContext(ioDispatcher){
        return@withContext try {
            Result.Success(categoryDAO.getCategories())
        }catch (e: Exception){
            Result.Error(e)
        }
    }

    override suspend fun saveCategory(item: CategoryEntity) = withContext(ioDispatcher){
        categoryDAO.insertCategory(item)
    }

}