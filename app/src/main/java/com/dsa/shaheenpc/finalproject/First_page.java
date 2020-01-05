package com.dsa.shaheenpc.finalproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsa.shaheenpc.finalproject.R;

public class First_page extends AppCompatActivity {
    CountDownTimer countDownTimer;
    Animation animation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        animation1=AnimationUtils.loadAnimation(this,R.anim.smalltobig);
        ImageView imageView=(ImageView)findViewById(R.id.img);
        TextView textView=(TextView)findViewById(R.id.txt);
        textView.setText(Html.fromHtml("<font color='#7c4dff'>P</font><font color='#ffb300'>B</font><font color='#00bfa5'>C</font>"));
        TextView textView1=(TextView)findViewById(R.id.txt1);

        Typeface mlight = Typeface.createFromAsset(getAssets(), "fonts/MontserratLight.ttf");
        Typeface logox = Typeface.createFromAsset(getAssets(), "fonts/Fredoka.ttf");
        textView1.setTypeface(logox);
        textView.setTypeface(logox);
        imageView.setAnimation(animation1);
        countDownTimer=new CountDownTimer(3000,3000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                finish();
         Intent intent=new Intent(getApplicationContext(),login_page.class);
         startActivity(intent);
         overridePendingTransition(R.anim.fadein, R.anim.fadout);



            }
        }.start();
    }
    }

