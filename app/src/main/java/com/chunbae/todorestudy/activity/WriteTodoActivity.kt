package com.chunbae.todorestudy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.CalendarView
import androidx.core.view.isVisible
import com.chunbae.todorestudy.databinding.ActivityWriteTodoBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WriteTodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriteTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWriteTodoBinding.inflate(layoutInflater)
        val fd = "sdff"
        println("앱 시작 $fd")
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTodayDate()
        setEditDate()


    }

    private fun setEditDate(){
        binding.calendar.setOnDateChangeListener(CalendarView.OnDateChangeListener { calendarView, year, month, day ->
            val curMonth = month+1
            val monthText = if(curMonth <10) "0$curMonth" else curMonth
            val dayText = if(day<10) "0$day" else day
            binding.etDate.setText("$year-$monthText-$dayText")
            binding.calendar.visibility = View.GONE
        })
    }


     fun setTodayDate(){
         val date = LocalDate.now()
         val formatter = DateTimeFormatter.ISO_DATE
         val dateResult = formatter.format(date)
         binding.etDate.setText(dateResult)
         binding.etDate.inputType = InputType.TYPE_NULL
         binding.calendar.visibility = View.GONE

         binding.etDate.setOnClickListener {
             binding.calendar.visibility = View.VISIBLE

         }
    }
}

