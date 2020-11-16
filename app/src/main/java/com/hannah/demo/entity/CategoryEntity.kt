package com.hannah.demo.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hannah.demo.R

/**
 * AUTHOR: hannah
 * DATE: 2020-11-10
 */
@Entity(tableName = "category")
data class CategoryEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    public val id: Long = 0,

    @ColumnInfo(name = "category_name")
    public val name: String = "",

    @NonNull
    @ColumnInfo(name = "category_icon")
    public val icon: Int = R.drawable.ic_add,


    @ColumnInfo(name = "category_type")
    public val type: Int = 0,

    @ColumnInfo(name = "category_account_id")
    public val accountId: Long = 0

)