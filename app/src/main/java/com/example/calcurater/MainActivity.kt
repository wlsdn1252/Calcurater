package com.example.calcurater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    // 계산기에서 바뀌는 값을 받기위해 변수 선언.
    private val firstNumberText = StringBuilder("")
    private val secondNumberText = StringBuilder("")
    private val operatorText = StringBuilder("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 메인.xml에서 직접 onCLick을 사용한 버튼을 구현하기 위한 함수 선언.
    fun numberClicked(view : View){
        Log.d("numberClicked","one")
    }
    fun clearClicked(view : View){

    }
    fun equalClicked(view : View){

    }
    fun operatorClicked(view : View){

    }
}