package com.hannah.demo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hannah.demo.entity.CategoryEntity
import com.hannah.demo.utils.Constants.DATABASE_NAME

/**
 * AUTHOR: hannah
 * DATE: 2020-11-10
 */
@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO

//    companion object {
//
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
//                .addCallback(object : RoomDatabase.Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
////                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
////                        WorkManager.getInstance(context).enqueue(request)
//                    }
//                })
//                .build()
//        }
//    }
}