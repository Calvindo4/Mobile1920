package com.github.snakeandladders

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import java.util.Random

class MainActivity : AppCompatActivity() {

    internal var xLoc = 1
    internal var rowLoc = 1

    internal var img: ImageView = findViewById(R.id.imageView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById<View>(R.id.imageView) as ImageView
    }

    fun btnMove_Click(view: View) {
        var Xaxis = 0
        val r = Random()
        var num = r.nextInt(6)

        num = if (num == 0) num + 1 else num

        val s = this.getString(R.string.dice_value, num)
        (findViewById<View>(R.id.textView) as TextView).text = s

        val par = img.layoutParams as RelativeLayout.LayoutParams

        xLoc = xLoc + num

        if (xLoc == 3) {
            xLoc = 17
        }
        if (xLoc == 15) {
            xLoc = 36
        }
        if (xLoc == 28) {
            xLoc = 7
        }
        if (xLoc == 32) {
            xLoc = 89
        }
        if (xLoc == 42) {
            xLoc = 76
        }
        if (xLoc == 66) {
            xLoc = 48
        }
        if (xLoc == 96) {
            xLoc = 77
        }
        if (xLoc == 99) {
            xLoc = 59
        }

        if (xLoc >= 1 && xLoc <= 10) {
            par.leftMargin = XTransformation(xLoc)
            par.bottomMargin = YTransformation(1)

        } else if (xLoc >= 11 && xLoc <= 20) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(10 - Xaxis + 1)
            par.bottomMargin = YTransformation(2)
        } else if (xLoc >= 21 && xLoc <= 30) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(Xaxis)
            par.bottomMargin = YTransformation(3)

        } else if (xLoc >= 31 && xLoc <= 40) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(10 - Xaxis + 1)
            par.bottomMargin = YTransformation(4)
        } else if (xLoc >= 41 && xLoc <= 50) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(Xaxis)
            par.bottomMargin = YTransformation(5)

        } else if (xLoc >= 51 && xLoc <= 60) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(10 - Xaxis + 1)
            par.bottomMargin = YTransformation(6)
        } else if (xLoc >= 61 && xLoc <= 70) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(Xaxis)
            par.bottomMargin = YTransformation(7)
        } else if (xLoc >= 71 && xLoc <= 80) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(10 - Xaxis + 1)
            par.bottomMargin = YTransformation(8)
        } else if (xLoc >= 81 && xLoc <= 90) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(Xaxis)
            par.bottomMargin = YTransformation(9)
        } else if (xLoc >= 91 && xLoc <= 100) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par.leftMargin = XTransformation(10 - Xaxis + 1)
            par.bottomMargin = YTransformation(10)
            if (xLoc >= 100) {
                xLoc = 100
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
                (findViewById<View>(R.id.btnMove) as Button).isEnabled = false
            }
        } else if (xLoc >= 100) {
            xLoc = 100
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            (findViewById<View>(R.id.btnMove) as Button).isEnabled = false
        }
        img.layoutParams = par
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Toast.makeText(this, "Left: " + (event.x.toString() + " Top: ") + event.y.toString(), Toast.LENGTH_SHORT).show()
        return super.onTouchEvent(event)
    }

    fun XTransformation(number: Int): Int {
        var left = 0
        when (number) {
            1 -> left = 15
            2 -> left = 125
            3 -> left = 230
            4 -> left = 340
            5 -> left = 445
            6 -> left = 555
            7 -> left = 660
            8 -> left = 770
            9 -> left = 880
            10 -> left = 980
        }
        return left
    }

    fun YTransformation(number: Int): Int {
        var bottom = 0
        when (number) {
            1 -> bottom = 300
            2 -> bottom = 405
            3 -> bottom = 515
            4 -> bottom = 620
            5 -> bottom = 730
            6 -> bottom = 835
            7 -> bottom = 940
            8 -> bottom = 1050
            9 -> bottom = 1160
            10 -> bottom = 1265
        }
        return bottom
    }

    fun btnReset_Click(view: View) {
        this.startActivity(Intent(this, MainActivity::class.java))
    }
}
