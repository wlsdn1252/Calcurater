package com.example.calcurater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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
        val numberString = (view as? Button)?.text?.toString() ?: ""
        val numberText = if(operatorText.isEmpty())firstNumberText else secondNumberText

        numberText.append(numberString)
        updateEquationTextView()
    }
    fun clearClicked(view : View){
        firstNumberText.clear()
        secondNumberText.clear()
        operatorText.clear()

        updateEquationTextView()
    }
    fun equalClicked(view : View){
        if(firstNumberText.isEmpty() || secondNumberText.isEmpty() || operatorText.isEmpty()){
            Toast.makeText(this, "올바르지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
            return
        }
        val firstNumber = firstNumberText.toString().toInt()
        val secondNumber = secondNumberText.toString().toInt()

        val result = when(operatorText.toString()){
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            else -> "잘못된 수식 입니다."
        }.toString()

        resultTextView.text = result
    }
    fun operatorClicked(view : View){
        val operatorString = (view as? Button)?.text?.toString() ?: ""

        if(firstNumberText.isEmpty()){
            Toast.makeText(this, "숫자를 먼저 입력해주세요",Toast.LENGTH_SHORT).show()
            return
        }
        if(secondNumberText.isNotEmpty()){
            Toast.makeText(this, "1개의 현산자에 대해서만 현산이 가능합니다.", Toast.LENGTH_SHORT).show()
            return
        }

        operatorText.append(operatorString)
        updateEquationTextView()
    }

    private fun updateEquationTextView(){
        equationTextView.text = "$firstNumberText $operatorText $secondNumberText"

    }
}