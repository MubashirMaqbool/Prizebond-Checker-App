package com.dsa.shaheenpc.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dsa.shaheenpc.finalproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Database_record extends AppCompatActivity {
    ListView listView;
    DataBase  dataBase;
    Cursor cursor;
    SQLiteDatabase db;
    ArrayList<String> strings;
    ArrayAdapter<String> stringArrayAdapter;
    TextView textView;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_record);
        listView=(ListView)findViewById(R.id.list);
        textView=(TextView)findViewById(R.id.tt1);
        button1=(Button)findViewById(R.id.button4);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><i>HISTORY</i></font>"));
        strings=new ArrayList<String >();
      //  stringArrayAdapter=new ArrayAdapter<String >(this,android.R.layout.simple_spinner_dropdown_item,strings);
       // listView.setAdapter(stringArrayAdapter);
        button1.setVisibility(View.INVISIBLE);
        dataBase=new DataBase(this);
        db = dataBase.getReadableDatabase();
        cursor=dataBase.ShowData();
       if(cursor.getCount()!=0){
           textView.setText("Click on Number to Search/Long Click to Delete Numbers");
           button1.setVisibility(View.VISIBLE);
       }
        if(cursor.getCount()==0){
            return;
        }
        //StringBuffer stringBuffer=new StringBuffer();
        while(cursor.moveToNext()){
            // String s1= String.valueOf(stringBuffer.append(cursor.getString(1)));
            // strings.add(s1);
            strings.add(cursor.getString(1));

            //  Toast.makeText(this,s1,Toast.LENGTH_LONG).show();
        }
        stringArrayAdapter=new ArrayAdapter<String >(this,android.R.layout.simple_spinner_dropdown_item,strings);
        listView.setAdapter(stringArrayAdapter);
        ////////////////////////////////////////////////
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                delRecord(position);
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Intent intent=new Intent(getApplicationContext(),single_number_search_2.class);
                  intent.putExtra("value",strings.get(position));
                  startActivity(intent);
                 // finish();
            }
        });
    }

    private void delRecord(final int position) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Do You Want To Delete the Number ?");
        builder.setIcon(R.drawable.del_icon);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Integer del=dataBase.DelData(strings.get(position));
                strings.remove(position);
                stringArrayAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.setCancelable(true);
            }
        });
           builder.show();
    }
    public void Random_Activity(View view){
        Intent intent=new Intent(getApplicationContext(),random_search_database.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fleft, R.anim.fhelper);
    }
}
