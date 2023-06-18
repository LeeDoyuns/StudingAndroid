package com.chunbae.todorestudy.db.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)   var id: Long? = 0,
    @ColumnInfo(name = "email")  var email: String,
    @ColumnInfo(name="password") var password: String
        ){

    constructor(email:String, password: String): this(null, email, password){
        this.email = email
        this.password = password
    }


}