package com.chunbae.todorestudy.db.dto

class LoginDTO (
    private var _email: String,
    private var password: String
        ){
    val email:String
    get() = this._email
}