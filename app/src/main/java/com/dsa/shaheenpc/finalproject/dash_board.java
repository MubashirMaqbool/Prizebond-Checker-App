package com.dsa.shaheenpc.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;
import android.widget.Toast;

import com.dsa.shaheenpc.finalproject.R;

public class dash_board extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.color4));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        CardView cardView1=(CardView)findViewById(R.id.bankcardId);
        CardView cardView2=(CardView)findViewById(R.id.c2);
        CardView cardView3=(CardView)findViewById(R.id.c3);
        CardView cardView4=(CardView)findViewById(R.id.c4);
        TextView textView1=(TextView)findViewById(R.id.t1);



        Typeface logox = Typeface.createFromAsset(getAssets(), "fonts/Fredoka.ttf");
        textView1.setTypeface(logox);
        cardView1.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                boolean check=CheckConnection();
                if(check==true){
                    Intent intent=new Intent(getApplicationContext(),single_number_search.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fleft, R.anim.fhelper);
                }
                else
                    Toast.makeText(getApplicationContext(), "Check Your Internet Connection !", Toast.LENGTH_LONG).show();




            }
        });
        cardView2.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                boolean check=CheckConnection();
                if(check==true){
                    Intent intent=new Intent(getApplicationContext(),range_search.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fleft, R.anim.fhelper);
                }
                else
                    Toast.makeText(getApplicationContext(), "Check Your Internet Connection !", Toast.LENGTH_LONG).show();
            }
        });
        cardView3.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                boolean check=CheckConnection();
                if(check==true){
                    Intent intent=new Intent(getApplicationContext(),random_numbers_search_activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fleft, R.anim.fhelper);
                }
                else
                    Toast.makeText(getApplicationContext(), "Check Your Internet Connection !", Toast.LENGTH_LONG).show();
            }
        });
        cardView4.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                    Intent intent=new Intent(getApplicationContext(),Search_by_file.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fleft, R.anim.fhelper);

            }
        });
    }
    public boolean CheckConnection(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null&&networkInfo.isConnected()){
            return  true;
        }
        else {
            return false;
        }
    }

}
