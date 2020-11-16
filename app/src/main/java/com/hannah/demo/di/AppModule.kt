package com.hannah.demo.di

import android.content.Context
import androidx.room.Room
import com.hannah.demo.database.*
import com.hannah.demo.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalTasksDataSource

    @Singleton
    @LocalTasksDataSource
    @Provides
    fun provideTasksLocalDataSource(
        database: CategoryDatabase,
        ioDispatcher: CoroutineDispatcher
    ): CategoryDataSource {
        return CategoryLocalDataSource(
            database.categoryDAO(), ioDispatcher
        )
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): CategoryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CategoryDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Module
    @InstallIn(ApplicationComponent::class)
    object CategoryRepositoryModule {
        @Singleton
        @Provides
        fun provideCategoryRepository(
            @AppModule.LocalTasksDataSource localDataSource: CategoryDataSource,
            ioDispatcher: CoroutineDispatcher
        ): CategoryRepository{
            return DefaultCategoryRepository(localDataSource, ioDispatcher)
        }
    }

}