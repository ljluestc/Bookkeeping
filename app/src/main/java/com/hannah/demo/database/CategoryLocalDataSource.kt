package com.hannah.demo.database

import androidx.lifecycle.LiveData
import com.hannah.demo.R
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.entity.Result
import com.hannah.demo.utils.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
class CategoryLocalDataSource(
    private val categoryDAO: CategoryDAO,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CategoryDataSource {

    override fun observeCategories(): LiveData<List<CategoryEntity>> {
        return categoryDAO.observeCategories()
    }

    override fun getCategories(): LiveData<List<CategoryEntity>> {
        return categoryDAO.getCategories()
    }

    override suspend fun saveCategory(item: CategoryEntity) = withContext(ioDispatcher) {
        val categoryEntityList = mutableListOf(
            CategoryEntity(
                name = "restaurant",
                type = Constants.TYPE_SPEND,
                icon = R.drawable.ic_menu_gallery
            ),
            CategoryEntity(
                name = "transport",
                type = Constants.TYPE_SPEND,
                icon = R.drawable.ic_menu_gallery
            ),
            CategoryEntity(
                name = "shopping",
                type = Constants.TYPE_SPEND,
                icon = R.drawable.ic_home_black_24dp
            ),
            CategoryEntity(
                name = "clothes",
                type = Constants.TYPE_SPEND,
                icon = R.drawable.ic_menu_camera
            ),
            CategoryEntity(
                name = "entertainment",
                type = Constants.TYPE_SPEND,
                icon = R.drawable.ic_menu_gallery
            ),
            CategoryEntity(
                name = "snack",
                type = Constants.TYPE_SPEND,
                icon = R.drawable.ic_home_black_24dp
            ),
            CategoryEntity(
                name = "add",
                type = Constants.TYPE_FOOT,
                icon = R.drawable.ic_menu_camera
            ),
        )
        categoryEntityList.forEach {
            categoryDAO.insertCategory(it)
        }
    }

    override suspend fun selectedCategory(category: CategoryEntity) = withContext(ioDispatcher){
        categoryDAO.selectedCategory(category.id, selected = true)
    }

    override suspend fun unSelectedCategory(unSelected: CategoryEntity) = withContext(ioDispatcher){
        categoryDAO.selectedCategory(unSelected.id, selected = false)
    }

    override suspend fun getCategoryById(id: Long): Result<CategoryEntity> =  withContext(ioDispatcher){
        try {
            val category = categoryDAO.getCategoryById(id)
            if (category != null) {
                return@withContext Result.Success(category)
            } else {
                return@withContext Result.Error(Exception("Category not found!"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun deleteAllCategories() = withContext(ioDispatcher) {
        categoryDAO.deleteAllCategories()
    }

    override suspend fun deleteCategoryById(categoryId: Long) = withContext<Unit>(ioDispatcher) {
        categoryDAO.deleteCategoryById(categoryId)
    }
}