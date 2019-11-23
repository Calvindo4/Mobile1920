package com.github.snakeandladders
package com.github.calvindo4.mobile1920

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
    internal var img: ImageView = findViewById(R.id.imageView)
    internal var par: RelativeLayout.LayoutParams? = null
    internal var xLoc = 1
    //int rowLoc = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById<View>(R.id.imageView) as ImageView
    }

    fun btnReset_Click(view: View) {
        this.startActivity(Intent(this, MainActivity::class.java))
    }

    fun btnMove_Click(view: View) {
        var Xaxis = 0

        val r = Random()
        val num = r.nextInt(6) + 1

        (findViewById<View>(R.id.textView) as TextView).text = num.toString()

        //par = (RelativeLayout.LayoutParams)img.getLayoutParams();

        xLoc = xLoc + num
        if (xLoc >= 1 && xLoc <= 10) {
            par!!.leftMargin = XTransformation(xLoc)
            par!!.bottomMargin = YTransformation(1)
        } else if (xLoc >= 11 && xLoc <= 20) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(10 - Xaxis + 1)
            par!!.bottomMargin = YTransformation(2)
        } else if (xLoc >= 21 && xLoc <= 30) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(Xaxis + 1)
            par!!.bottomMargin = YTransformation(3)
        } else if (xLoc >= 31 && xLoc <= 40) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(10 - Xaxis + 1)
            par!!.bottomMargin = YTransformation(4)
        } else if (xLoc >= 41 && xLoc <= 50) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(Xaxis + 1)
            par!!.bottomMargin = YTransformation(5)
        } else if (xLoc >= 51 && xLoc <= 60) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(10 - Xaxis + 1)
            par!!.bottomMargin = YTransformation(6)
        } else if (xLoc >= 61 && xLoc <= 70) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(Xaxis + 1)
            par!!.bottomMargin = YTransformation(7)
        } else if (xLoc >= 71 && xLoc <= 80) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(10 - Xaxis + 1)
            par!!.bottomMargin = YTransformation(8)
        } else if (xLoc >= 81 && xLoc <= 90) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(Xaxis + 1)
            par!!.bottomMargin = YTransformation(9)
        } else if (xLoc >= 91 && xLoc <= 100) {
            Xaxis = if (xLoc % 10 == 0) 10 else xLoc % 10
            par!!.leftMargin = XTransformation(10 - Xaxis + 1)
            par!!.bottomMargin = YTransformation(10)
        } else if (xLoc >= 100) {
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            (findViewById<View>(R.id.btnMove) as Button).isEnabled = false
        }//Right to left movement
        //Right to left movement
        //Left to right movement
        //Right to left movement
        //Left to right movement
        //Right to left movement
        //Left to right movement
        //Right to left movement

        img.layoutParams = par
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "Left: " + String.valueOf(event.getX() + " Top: ") + String.valueOf(event.getY()), Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }*/

    fun XTransformation(number: Int): Int {
        var left = 0
        when (number) {
            1 -> left = 300
            2 -> left = 125
            3 -> left = 230
            4 -> left = 340
            5 -> left = 445
            6 -> left = 555
            7 -> left = 660
            8 -> left = 770
            9 -> left = 880
            10 -> left = 985
        }
        return left
    }

    fun YTransformation(number: Int): Int {
        var bottom = 0
        when (number) {
            1 -> bottom = 350
            2 -> bottom = 500
            3 -> bottom = 600
            4 -> bottom = 800
            5 -> bottom = 1060
            6 -> bottom = 1250
            7 -> bottom = 1350
            8 -> bottom = 1450
            9 -> bottom = 1550
            10 -> bottom = 1650
        }
        return bottom
    }
}
