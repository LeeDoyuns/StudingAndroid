package com.chunbae.todorestudy.db.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.chunbae.todorestudy.db.entity.user.User

@Dao
interface UserDao {

    //getAllUsers
    @Query("select * from user")
    fun getAllUser():List<User>

    //selectUser
    @Query("select * from user where email = :email")
    fun selectUser(email: String): User

    @Insert
    fun insertUser(user: User): Long

    @Update
    fun updateUser(user: User)
}