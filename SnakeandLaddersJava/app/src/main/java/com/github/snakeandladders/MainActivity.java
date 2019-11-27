package com.github.snakeandladders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int xLoc = 1;
    int rowLoc = 1;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = ((ImageView)findViewById(R.id.imageView));
    }

    public void btnMove_Click(View view) {
        int Xaxis = 0;
        Random r = new Random();
        int num = r.nextInt(6);

        num=num==0?num+1:num;

        String s = this.getString(R.string.dice_value,num);
        ((TextView)findViewById(R.id.textView)).setText(s);

        RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)img.getLayoutParams();

        xLoc = xLoc + num;

        if(xLoc == 3){
            xLoc = 17;
        }
        if(xLoc == 15){
            xLoc = 36;
        }
        if(xLoc == 28){
            xLoc = 7;
        }
        if(xLoc == 32){
            xLoc = 89;
        }
        if(xLoc == 42){
            xLoc = 76;
        }
        if(xLoc == 66){
            xLoc = 48;
        }
        if(xLoc == 96){
            xLoc = 77;
        }
        if(xLoc == 99){
            xLoc = 59;
        }

        if(xLoc >= 1 && xLoc <= 10) {
            par.leftMargin = XTransformation(xLoc);
            par.bottomMargin = YTransformation(1);

        }
        else if(xLoc >= 11 && xLoc <= 20) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(10-Xaxis+1);
            par.bottomMargin = YTransformation(2);
        }
        else if(xLoc >= 21 && xLoc <= 30) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(Xaxis);
            par.bottomMargin = YTransformation(3);

        }
        else if(xLoc >= 31 && xLoc <= 40) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(10-Xaxis+1);
            par.bottomMargin = YTransformation(4);
        }
        else if(xLoc >= 41 && xLoc <= 50) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(Xaxis);
            par.bottomMargin = YTransformation(5);

        }
        else if(xLoc >= 51 && xLoc <= 60) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(10-Xaxis+1);
            par.bottomMargin = YTransformation(6);
        }
        else if(xLoc >= 61 && xLoc <= 70) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(Xaxis);
            par.bottomMargin = YTransformation(7);
        }
        else if(xLoc >= 71 && xLoc <= 80) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(10-Xaxis+1);
            par.bottomMargin = YTransformation(8);
        }
        else if(xLoc >= 81 && xLoc <= 90) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(Xaxis);
            par.bottomMargin = YTransformation(9);
        }
        else if(xLoc >= 91 && xLoc <= 100) {
            Xaxis = xLoc%10==0?10:xLoc%10;
            par.leftMargin = XTransformation(10-Xaxis+1);
            par.bottomMargin = YTransformation(10);
            if(xLoc >= 100) {
                xLoc = 100;
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show();
                ((Button)findViewById(R.id.btnMove)).setEnabled(false);
            }
        }
        else if(xLoc >= 100) {
            xLoc = 100;
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show();
            ((Button)findViewById(R.id.btnMove)).setEnabled(false);
        }
        img.setLayoutParams(par);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "Left: " + String.valueOf(event.getX() + " Top: ") + String.valueOf(event.getY()), Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    public int XTransformation (int number) {
        int left = 0;
        switch (number) {
            case 1:
                left = 15;
                break;
            case 2:
                left = 125;
                break;
            case 3:
                left = 230;
                break;
            case 4:
                left = 340;
                break;
            case 5:
                left = 445;
                break;
            case 6:
                left = 555;
                break;
            case 7:
                left = 660;
                break;
            case 8:
                left = 770;
                break;
            case 9:
                left = 880;
                break;
            case 10:
                left = 980;
                break;
        }
        return left;
    }

    public int YTransformation (int number) {
        int bottom = 0;
        switch (number) {
            case 1:
                bottom = 300;
                break;
            case 2:
                bottom = 405;
                break;
            case 3:
                bottom = 515;
                break;
            case 4:
                bottom = 620;
                break;
            case 5:
                bottom = 730;
                break;
            case 6:
                bottom = 835;
                break;
            case 7:
                bottom = 940;
                break;
            case 8:
                bottom = 1050;
                break;
            case 9:
                bottom = 1160;
                break;
            case 10:
                bottom = 1265;
                break;
        }
        return bottom;
    }

    public void btnReset_Click(View view) {
        this.startActivity(new Intent(this, MainActivity.class));
    }
}
