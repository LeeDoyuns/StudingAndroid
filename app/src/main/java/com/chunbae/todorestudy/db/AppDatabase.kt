package com.chunbae.todorestudy.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chunbae.todorestudy.db.entity.user.User
import com.chunbae.todorestudy.db.repository.UserDao

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getUserDao() : UserDao
//    abstract fun getPetDao() : PetDao

    companion object {
         val databaseName = "db_mypet"
        private lateinit var appDatabase: AppDatabase

        fun getInstance(context: Context, testMode: Boolean = true) : AppDatabase {
            synchronized(AppDatabase::class){
                appDatabase =  Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    databaseName
                ).build()

            }
        return appDatabase
        }
    }

}