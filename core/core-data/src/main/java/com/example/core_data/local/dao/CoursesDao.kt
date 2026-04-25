package com.example.core_data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_data.constant.DataBaseConstant.USER_ID
import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

@Dao
interface CoursesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCourse(course: CoursesEntity)

    @Delete
    suspend fun deleteCourse(course: CoursesEntity)

    @Query("SELECT * FROM courses")
    suspend fun getLikedCourse(): List<CoursesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUser(userId: Int = USER_ID): UserEntity
}