package com.dsa.shaheenpc.finalproject;

import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.animation.Animation;
import android.widget.TextView;

import com.dsa.shaheenpc.finalproject.R;

import org.w3c.dom.Text;

import me.biubiubiu.justifytext.library.JustifyTextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class how_to_use extends AppCompatActivity {
    Animation smalltobig, fleft, fhelper;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><i>How to Use App</i></font>"));
        Typeface logox = Typeface.createFromAsset(getAssets(), "fonts/Fredoka.ttf");
        Typeface mlight = Typeface.createFromAsset(getAssets(), "fonts/MontserratLight.ttf");
        Typeface mmedium = Typeface.createFromAsset(getAssets(), "fonts/MontserratMedium.ttf");
        Typeface mregular = Typeface.createFromAsset(getAssets(), "fonts/MontserratRegular.ttf");
        TextView textView1=(TextView)findViewById(R.id.t1);
        TextView textView2=(TextView)findViewById(R.id.t2);
        JustifyTextView textView3=(JustifyTextView) findViewById(R.id.t3);
        TextView textView4=(TextView)findViewById(R.id.t4);
        JustifyTextView textView5=(JustifyTextView) findViewById(R.id.t5);
        TextView textView6=(TextView)findViewById(R.id.t6);
        JustifyTextView textView7=(JustifyTextView) findViewById(R.id.t7);
        textView1.setTypeface(logox);
        textView1.setTranslationX(400);
        textView2.setTranslationX(400);
        textView3.setTranslationX(400);
        textView4.setTranslationX(400);
        textView5.setTranslationX(400);
        textView6.setTranslationX(400);
        textView7.setTranslationX(400);
        textView2.setAlpha(0);
        textView1.setAlpha(0);
        textView3.setAlpha(0);
        textView4.setAlpha(0);
        textView5.setAlpha(0);
        textView6.setAlpha(0);
        textView7.setAlpha(0);
        textView2.setTypeface(mmedium);
        textView3.setTypeface(mmedium);
        textView4.setTypeface(mmedium);
        textView5.setTypeface(mmedium);
        textView6.setTypeface(mmedium);
        textView7.setTypeface(mmedium);
        textView1.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        textView2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        textView3.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        textView4.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        textView5.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        textView6.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        textView7.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();







    }
}
