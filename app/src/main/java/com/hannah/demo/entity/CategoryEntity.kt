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
    val id: Long = 0,

    @ColumnInfo(name = "category_name")
    val name: String = "",

    @NonNull
    @ColumnInfo(name = "category_icon")
    val icon: Int = 0,

    @ColumnInfo(name = "category_type")
    val type: Int = 0,

    @ColumnInfo(name = "category_account_id")
    val accountId: Long = 0

)