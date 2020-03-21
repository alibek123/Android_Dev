package com.example.calculator_kotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    var operation: String? = null
    var num1: String? = null
    var num2: String? = null
    var dot: String? = null
    var number1 = 0.0
    var number2 = 0.0
    var output = 0.0
    var out: String? = null
    var dooot: CharSequence? = null
    var sign = false
    var rad = false

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = tv.text.toString()
        val o = tvO.text.toString()
        outState.putString("operation", operation)
        outState.putString("number1", num1)
        outState.putString("text", s)
        outState.putString("out", o)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        infoTextView.append(savedInstanceState.getString("text"))
        tvO.append(savedInstanceState.getString("out"))
        operation = savedInstanceState.getString("operation")
        num1 = savedInstanceState.getString("number1")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sign = false
        operation = ""
        num2 = ""
        dot = ""
        number1 = 0.0
        number2 = 0.0
        output = 0.0
        out = ""
        dooot = "."
        rad = false
    }

    fun onClick(view: View) {
        val tv = view as TextView
        val s = tv.text.toString()
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        val text = infoTextView.text.toString()
        if (text == "0") infoTextView.text = s else infoTextView.append(s)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
    }

    fun pressDot(view: View) {
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val text = infoTextView.text.toString()
        if (!text.contains(dooot.toString())) {
            infoTextView.append(".")
        }
    }

    fun pressZero(view: View) {
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val text = infoTextView.text.toString()
        if (!text.equals("0")) {
            infoTextView.append("0")
        }
    }

    fun clearAll(view: View) {
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        infoTextView.text = ""
        rad = false
    }

    fun delete(view: View) {
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        var s = infoTextView.text.toString()
        if (s != "") {
            s = s.substring(0, s.length - 1)
            infoTextView.text = s
        }
    }

    fun pressPlus(view: View) {
        val infoTextView = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = infoTextView.text.toString()
        if (!s.equals("")) {
            if (!sign) {
                tvO.text = ""
                sign = true
                num1 = infoTextView.text.toString()
                infoTextView.text = ""
                operation = "+"
            } else {
                operation = "+"
            }
        }
    }


}
