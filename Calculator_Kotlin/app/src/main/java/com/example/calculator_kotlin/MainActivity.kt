package com.example.calculator_kotlin

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

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
        if (text.equals("0")) {
            infoTextView.text = s
        } else infoTextView.append(s)
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

    fun pressMinus(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = tv.text.toString()
        if (s != "") {
            if (!sign) {
                tvO.text = ""
                sign = true
                num1 = tv.text.toString()
                tv.text = ""
                operation = "-"
            } else {
                operation = "-"
            }
        }
    }

    fun pressPercent(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = tv.text.toString()
        if (s != "") {
            if (!sign) {
                tvO.text = ""
                sign = true
                if (s != "") {
                    num1 = tv.text.toString()
                    tv.text = ""
                    operation = "%"
                }
            } else {
                operation = "%"
            }
        }
    }

    fun pressMulti(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = tv.text.toString()
        if (s != "") {
            if (!sign) {
                tvO.text = ""
                sign = true
                if (s != "") {
                    num1 = tv.text.toString()
                    tv.text = ""
                    operation = "*"
                }
            } else {
                operation = "*"
            }
        }
    }

    fun pressDiv(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = tv.text.toString()
        if (s != "") {
            if (!sign) {
                tvO.text = ""
                sign = true
                if (s != "") {
                    num1 = tv.text.toString()
                    tv.text = ""
                    operation = "/"
                }
            } else {
                operation = "/"
            }
        }
    }


    fun pressSqrt() {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val text = tv.text.toString()
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        if (text != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            output = sqrt(number1)
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    fun pressPi(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val pi = Math.PI
        tv.text = pi.toString()
    }


    fun pressLog(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            output = log10(number1)
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    fun pressLogN(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            output = ln(number1)
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    private fun factorial(n: Int): Int {
        return if (n == 0) 1 else n * factorial(n - 1)
    }

    fun pressFactorial(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toInt().toDouble()
            output = factorial(number1.toInt()).toDouble()
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    fun pressDouble(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            output = number1 * number1
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    fun pressPower(view: View) {
        if (!sign) {
            val tv = findViewById<TextView>(R.id.tvExpression)
            val tvO = findViewById<TextView>(R.id.tvOut)
            tvO.text = ""
            val s = tv.text.toString()
            sign = true
            if (s != "") {
                num1 = tv.text.toString()
                tv.text = ""
                operation = "^"
            }
        } else {
            operation = "^"
        }
    }

    fun degToRad(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            if (!rad) {
                output = Math.toRadians(number1)
                out = output.toString()
                tv.text = out
                rad = true
            }
        }
    }

    fun radianToD(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            if (rad) {
                output = Math.toDegrees(number1)
                out = output.toString()
                tv.text = out
                rad = false
            }
        }
    }

    fun sin(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            if (!rad) {
                output = sin(Math.toRadians(number1))
                tv.text = ""
                out = output.toString()
                tvO.append(out)
            } else {
                output = sin(number1)
                tv.text = ""
                out = output.toString()
                tvO.append(out)
            }
        }
    }

    fun cos(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            if (!rad) {
                output = cos(Math.toRadians(number1))
                tv.text = ""
                out = output.toString()
                tvO.append(out)
            } else {
                output = cos(number1)
                tv.text = ""
                out = output.toString()
                tvO.append(out)
            }
        }
    }

    fun tan(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            if (!rad) {
                output = tan(Math.toRadians(number1))
                tv.text = ""
                out = output.toString()
                tvO.append(out)
            } else {
                output = tan(number1)
                tv.text = ""
                out = output.toString()
                tvO.append(out)
            }
        }
    }

    fun exp(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            output = exp(number1)
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    fun inverse(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        tvO.text = ""
        val s = tv.text.toString()
        if (s != "") {
            num1 = tv.text.toString()
            number1 = num1!!.toDouble()
            output = 1 / number1
            tv.text = ""
            out = output.toString()
            tvO.append(out)
        }
    }

    fun pressEquals(view: View) {
        val tv = findViewById<TextView>(R.id.tvExpression)
        val tvO = findViewById<TextView>(R.id.tvOut)
        val s = tv.text.toString()
        tvO.setTextColor(Color.rgb(255, 255, 255))
        if (s != "") {
            if (operation == "+") {
                num2 = tv.text.toString()
                number1 = num1!!.toDouble()
                number2 = num2!!.toDouble()
                output = number1 + number2
                out = output.toString()
                tvO.text = out
                operation = ""
                sign = false
            }
            if (operation == "-") {
                num2 = tv.text.toString()
                number1 = num1!!.toDouble()
                number2 = num2!!.toDouble()
                output = number1 - number2
                out = output.toString()
                tvO.text = out
                operation = ""
                sign = false
            }
            if (operation == "*") {
                num2 = tv.text.toString()
                number1 = num1!!.toDouble()
                number2 = num2!!.toDouble()
                output = number1 * number2
                out = output.toString()
                tvO.text = out
                operation = ""
                sign = false
            }
            if (operation == "/") {
                num2 = tv.text.toString()
                number1 = num1!!.toDouble()
                number2 = num2!!.toDouble()
                if (number1 == 0.0 || number2 == 0.0) {
                    tvO.setTextColor(Color.rgb(249, 174, 171))
                    tvO.text = "На 0 делить нельзя"
                } else {
                    output = number1 / number2
                    out = output.toString()
                    tvO.text = out
                    operation = ""
                }
                operation = ""
                sign = false
            }
            if (operation == "%") {
                num2 = tv.text.toString()
                number1 = num1!!.toDouble()
                number2 = num2!!.toDouble()
                val percent = number2 / 100
                output = number1 * percent
                out = output.toString()
                tvO.text = out
                operation = ""
                sign = false
            }
            if (operation == "^") {
                num2 = tv.text.toString()
                number1 = num1!!.toDouble()
                number2 = num2!!.toDouble()
                output = Math.pow(number1, number2)
                out = output.toString()
                tvO.text = out
                operation = ""
                sign = false
            }
        }
        tv.text = ""
        rad = false
    }


}
