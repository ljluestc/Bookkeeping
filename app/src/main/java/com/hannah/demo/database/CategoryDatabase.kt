package com.hannah.demo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hannah.demo.entity.CategoryEntity

/**
 * AUTHOR: hannah
 * DATE: 2020-11-10
 */
@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO

}