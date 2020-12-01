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

}