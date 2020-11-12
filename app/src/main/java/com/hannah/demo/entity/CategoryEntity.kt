package com.hannah.demo.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * AUTHOR: hannah
 * DATE: 2020-11-10
 */
@Entity(tableName = "category")
data class CategoryEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    private val id: Long = 0,

    @ColumnInfo(name = "category_name")
    private val name: String = "",

    @NonNull
    @ColumnInfo(name = "category_icon")
    private val icon: String = "",

    @ColumnInfo(name = "category_type")
    private val type: Int = 0,

    @ColumnInfo(name = "category_account_id")
    private val accountId: Long = 0

)