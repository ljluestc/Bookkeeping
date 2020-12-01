package com.hannah.demo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hannah.demo.entity.CategoryEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-11-10
 */
@Dao
interface CategoryDAO {

    @Query("SELECT * FROM category")
    fun observeCategories(): LiveData<List<CategoryEntity>>

    @Query("SELECT * FROM category")
    fun getCategories(): LiveData<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(item: CategoryEntity)

    @Query("SELECT * FROM category WHERE category_id = :id")
    suspend fun getCategoryById(id: Long): CategoryEntity?

    @Query("UPDATE category SET category_selected = :selected WHERE category_id = :id")
    suspend fun selectedCategory(id: Long, selected: Boolean)

    @Query("DELETE FROM category")
    suspend fun deleteAllCategories()

    @Query("DELETE FROM category WHERE category_id = :categoryId")
    suspend fun deleteCategoryById(categoryId: Long): Int

}