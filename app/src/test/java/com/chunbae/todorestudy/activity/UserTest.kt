package com.chunbae.todorestudy.test.activity

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chunbae.todorestudy.db.AppDatabase
import com.chunbae.todorestudy.db.entity.user.User
import com.chunbae.todorestudy.db.repository.UserDao
import junit.framework.TestCase
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var userDao: UserDao
    private lateinit var db: AppDatabase

    @Before
    fun setup(){
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        userDao = db.getUserDao() 
    }

    @After
    fun dbShutdown(){
        db.close()
    }


    @Test
    fun saveUser(){
        val user = User("email@naver.com", "12345")
        val user2 = User("falseResult@naver.com", "12345")
        var result= userDao.insertUser(user)

        var result2 = userDao.selectUser(user.email)
        TestCase.assertEquals(result2.email, user2.email)
    }
}