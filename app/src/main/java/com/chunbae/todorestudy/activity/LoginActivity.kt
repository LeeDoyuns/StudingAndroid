package com.chunbae.todorestudy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import com.chunbae.todorestudy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setEmailText()
        btnEvent()

    }

    /*추후 이메일 정합성체크 관련 링크
    https://lcw126.tistory.com/282
    * */
    private fun setEmailText(){
        binding.etEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
    }

    private fun btnEvent(){

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
    }
}