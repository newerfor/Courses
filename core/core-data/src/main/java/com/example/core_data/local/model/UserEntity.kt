package com.example.core_data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core_data.constant.DataBaseConstant.USER_ID

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: Int = USER_ID,
    val email: String,
    val password: String
)
