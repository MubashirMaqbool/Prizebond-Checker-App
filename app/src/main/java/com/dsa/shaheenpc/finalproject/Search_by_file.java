package com.dsa.shaheenpc.finalproject;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Search_by_file extends AppCompatActivity {
    TextView textView;
     Button but_upload;
     Button but_search;
     ListView listView_1;
     ArrayList<String> strings;
     ArrayAdapter<String> stringArrayAdapter_1;
    Spinner spinner1,spinner2;
    String a,b,c,d;
    String a_200,b_200,c_200,d_200="";
    String a_1500,b_1500,c_1500,d_1500="";
    String a_750,b_750,c_750,d_750,a1_750="";
    String a_7500,b_7500,c_7500,d_7500,a1_7500="";
    String a_15000,b_15000,c_15000,d_15000,link_15000_1="";
    String a_25000,b_25000,c_25000,d_25000,a1_25000="";
    String a_40000,b_40000,c_40000,d_40000="";
    String a_40000p,b_40000p,c_40000p,d_40000p="";
    ProgressDialog progressDialog1;
    String prizebond_data="";
    DataBase dataBase;
    SQLiteDatabase db;
    DatabaseReference databaseReference,databaseReference1,databaseReference2,databaseReference3,databaseReference4,databaseReference5,databaseReference6,databaseReference7,databaseReference8,databaseReference9;
    DatabaseReference ref200,ref350,ref750,ref15000,ref1500,ref25000,ref40000,ref40000pr,ref7500;
    String datevalue200_1,datetevalue200_2,datevalue200_3,datevalue200_4= "";
    String datevalue100_1,datevalue100_2,datevalue100_3,datevalue100_4="";
    String datevalue750_1,datevalue750_2,datevalue750_3,datevalue750_4,datevalue750_1_019="";
    String datevalue1500_1,datevalue1500_2,datevalue1500_3,datevalue1500_4="";
    String datevalue7500_1,datevalue7500_2,datevalue7500_3,datevalue7500_4,datevalue_7500_1_019="";
    String datevalue15000_1,datevalue15000_2,datevalue15000_3,datevalue15000_4,datevalue_15000_1_2019="";
    String datevalue25000_1,datevalue25000_2,datevalue25000_3,datevalue25000_4,datevalue_1_25000_019="";
    String datevalue40000_1,datevalue40000_2,datevalue40000_3,datevalue40000_4="";
    String datevalue40000p_1,datevalue40000p_2,datevalue40000p_3,datevalue40000p_4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_file);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><i>Search Your Bond</i></font>"));
        but_upload=(Button)findViewById(R.id.button);
        but_search=(Button)findViewById(R.id.button2);
        listView_1=(ListView)findViewById(R.id.list);
        spinner1 = (Spinner) findViewById(R.id.sp1);
        spinner2 = (Spinner) findViewById(R.id.sp2);
        textView=(TextView)findViewById(R.id.text1);
        strings =new ArrayList<>();
        stringArrayAdapter_1=new ArrayAdapter<String >(this,android.R.layout.simple_spinner_dropdown_item,strings);
        listView_1.setAdapter(stringArrayAdapter_1);
        //getting dates
        String[] item1=new String[]{"Select Your Prize Bond Date","Please ! Fisrt Select Your Bond Type"};
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(Search_by_file.this,android.R.layout.simple_list_item_1,item1);
        spinner2.setAdapter(stringArrayAdapter);
        String[] item = new String[]{"Please Select Your Bond","100", "200", "750","1500","7500","15000","25000","40000","40000 Premium"};
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, item);
        spinner1.setAdapter(adapters);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner1.getSelectedItem().equals("100")){
                    showLoading();
                    databaseReference1 = FirebaseDatabase.getInstance().getReference().child("date_100list_2018");
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue100_1 = String.valueOf(dataSnapshot.child("15-02-2018").getValue());
                            datevalue100_2 = String.valueOf(dataSnapshot.child("15-05-2018").getValue());
                            datevalue100_3 = String.valueOf(dataSnapshot.child("15-08-2018").getValue());
                            datevalue100_4 = String.valueOf(dataSnapshot.child("15-11-2018").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue100_1,datevalue100_2,datevalue100_3,datevalue100_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }


                else if(spinner1.getSelectedItem().equals("200")){
                    showLoading();
                    databaseReference2 = FirebaseDatabase.getInstance().getReference().child("date_200list_2018");
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            datevalue200_1 = String.valueOf(dataSnapshot.child("15-03-2018").getValue());
                            datetevalue200_2 = String.valueOf(dataSnapshot.child("17-09-2018").getValue());
                            datevalue200_3 = String.valueOf(dataSnapshot.child("17-12-2018").getValue());
                            datevalue200_4 = String.valueOf(dataSnapshot.child("19-06-2018").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue200_1,datetevalue200_2,datevalue200_3,datevalue200_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(spinner1.getSelectedItem().equals("750")){
                    showLoading();
                    databaseReference3 = FirebaseDatabase.getInstance().getReference().child("date_750list_2018");
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue750_1 = String.valueOf(dataSnapshot.child("15-01-2018").getValue());
                            datevalue750_2 = String.valueOf(dataSnapshot.child("15-10-2018").getValue());
                            datevalue750_3 = String.valueOf(dataSnapshot.child("16-04-2018").getValue());
                            datevalue750_4 = String.valueOf(dataSnapshot.child("16-07-2018").getValue());
                            datevalue750_1_019=String.valueOf(dataSnapshot.child("15-01-2019").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue750_1_019,datevalue750_1, datevalue750_2, datevalue750_3, datevalue750_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                ////
                else   if(spinner1.getSelectedItem().equals("1500")){
                    showLoading();
                    databaseReference4 = FirebaseDatabase.getInstance().getReference().child("date_1500list_2018");
                    databaseReference4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue1500_1 = String.valueOf(dataSnapshot.child("15-02-2018").getValue());
                            datevalue1500_2 = String.valueOf(dataSnapshot.child("15-05-2018").getValue());
                            datevalue1500_3 = String.valueOf(dataSnapshot.child("15-08-2018").getValue());
                            datevalue1500_4 = String.valueOf(dataSnapshot.child("15-11-2018").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue1500_1, datevalue1500_2, datevalue1500_3, datevalue1500_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                ///////////////
                else    if(spinner1.getSelectedItem().equals("15000")){
                    showLoading();
                    databaseReference5 = FirebaseDatabase.getInstance().getReference().child("date_15000list_2018");
                    databaseReference5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue15000_4 = String.valueOf(dataSnapshot.child("01-10-2018").getValue());
                            datevalue15000_1 = String.valueOf(dataSnapshot.child("02-01-2018").getValue());
                            datevalue15000_2 = String.valueOf(dataSnapshot.child("02-04-2018").getValue());
                            datevalue15000_3 = String.valueOf(dataSnapshot.child("03-07-2018").getValue());
                            datevalue_15000_1_2019=String.valueOf(dataSnapshot.child("02-01-2019").getValue());

                            String[] items = new String[]{"Please Select Data",datevalue_15000_1_2019,datevalue15000_1, datevalue15000_2, datevalue15000_3, datevalue15000_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                //////////////////////

                else    if(spinner1.getSelectedItem().equals("25000")){
                    showLoading();
                    databaseReference6 = FirebaseDatabase.getInstance().getReference().child("date_250000list_2018");
                    databaseReference6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue25000_1 = String.valueOf(dataSnapshot.child("01-02-2018").getValue());
                            datevalue25000_3 = String.valueOf(dataSnapshot.child("01-08-2018").getValue());
                            datevalue25000_4 = String.valueOf(dataSnapshot.child("01-11-2018").getValue());
                            datevalue25000_2 = String.valueOf(dataSnapshot.child("02-05-2018").getValue());
                            datevalue_1_25000_019 = String.valueOf(dataSnapshot.child("01-02-2019").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue25000_1, datevalue25000_2, datevalue25000_3, datevalue25000_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                //////////////////////////////////////////
                else   if(spinner1.getSelectedItem().equals("40000")){
                    showLoading();
                    databaseReference7 = FirebaseDatabase.getInstance().getReference().child("date_40000list_2018");
                    databaseReference7.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue40000_1 = String.valueOf(dataSnapshot.child("01-03-2018").getValue());
                            datevalue40000_2 = String.valueOf(dataSnapshot.child("01-06-2018").getValue());
                            datevalue40000_3 = String.valueOf(dataSnapshot.child("03-12-2018").getValue());
                            datevalue40000_4 = String.valueOf(dataSnapshot.child("08-09-2018").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue40000_1, datevalue40000_2, datevalue40000_3, datevalue40000_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                /////////////////////////////
                else  if(spinner1.getSelectedItem().equals("40000 Premium")){
                    showLoading();
                    databaseReference8 = FirebaseDatabase.getInstance().getReference().child("date_40000premlist_2018");
                    databaseReference8.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue40000p_1 = String.valueOf(dataSnapshot.child("10-12-2018").getValue());
                            datevalue40000p_2 = String.valueOf(dataSnapshot.child("11-06-2018").getValue());
                            datevalue40000p_3 = String.valueOf(dataSnapshot.child("11-09-2018").getValue());
                            datevalue40000p_4 = String.valueOf(dataSnapshot.child("12-03-2018").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue40000p_1, datevalue40000p_2, datevalue40000p_3, datevalue40000p_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
                /////////////////////////
                else  if(spinner1.getSelectedItem().equals("7500")){
                    showLoading();
                    databaseReference9 = FirebaseDatabase.getInstance().getReference().child("date_7500list_2018");
                    databaseReference9.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            datevalue7500_1 = String.valueOf(dataSnapshot.child("01-02-2018").getValue());
                            datevalue7500_3 = String.valueOf(dataSnapshot.child("01-08-2018").getValue());
                            datevalue7500_4 = String.valueOf(dataSnapshot.child("01-11-2018").getValue());
                            datevalue7500_2 = String.valueOf(dataSnapshot.child("02-05-2018").getValue());
                            datevalue_7500_1_019 = String.valueOf(dataSnapshot.child("01-02-2019").getValue());
                            String[] items = new String[]{"Please Select Data",datevalue_7500_1_019,datevalue7500_1, datevalue7500_2, datevalue7500_3, datevalue7500_4};
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_by_file.this, android.R.layout.simple_spinner_dropdown_item, items);
                            spinner2.setAdapter(adapter);
                            progressDialog1.dismiss();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /////end of date methods
        databaseReference = FirebaseDatabase.getInstance().getReference().child("100_pzl_2018");
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                a = dataSnapshot.child("1st").getValue().toString();
                b = dataSnapshot.child("2nd").getValue().toString();
                c=dataSnapshot.child("3rd").getValue().toString();
                d=dataSnapshot.child("4th").getValue().toString();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // 200 List link
        ref200 = FirebaseDatabase.getInstance().getReference().child("200_pzl_list");
        ref200.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                a_200 = dataSnapshot.child("1st").getValue().toString();
                b_200 = dataSnapshot.child("2nd").getValue().toString();
                c_200=dataSnapshot.child("3rd").getValue().toString();
                d_200=dataSnapshot.child("4th").getValue().toString();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //ref 750
        ref750 = FirebaseDatabase.getInstance().getReference().child("750_pzl_list");
        ref750.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                a_750 = dataSnapshot.child("1st").getValue().toString();
                b_750= dataSnapshot.child("2nd").getValue().toString();
                c_750=dataSnapshot.child("3rd").getValue().toString();
                d_750=dataSnapshot.child("4th").getValue().toString();
                a1_750=dataSnapshot.child("5th").getValue().toString();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref1500=FirebaseDatabase.getInstance().getReference().child("1500_pzl_list");
        ref1500.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a_1500 = dataSnapshot.child("15-02-2018").getValue().toString();
                b_1500= dataSnapshot.child("15-05-2018").getValue().toString();
                c_1500=dataSnapshot.child("15-08-2018").getValue().toString();
                d_1500=dataSnapshot.child("15-11-2018").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref7500=FirebaseDatabase.getInstance().getReference().child("7500_pzl_list");
        ref7500.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a_7500 = dataSnapshot.child("01-02-2018").getValue().toString();
                b_7500= dataSnapshot.child("02-05-2018").getValue().toString();
                c_7500=dataSnapshot.child("01-08-2018").getValue().toString();
                d_7500=dataSnapshot.child("01-11-2018").getValue().toString();
                a1_7500=dataSnapshot.child("01-02-2019").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref15000=FirebaseDatabase.getInstance().getReference().child("15000_pzl_2018");
        ref15000.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a_15000 = dataSnapshot.child("02-01-2018").getValue().toString();
                b_15000= dataSnapshot.child("02-04-2018").getValue().toString();
                c_15000=dataSnapshot.child("03-07-2018").getValue().toString();
                d_15000=dataSnapshot.child("01-10-2018").getValue().toString();
                link_15000_1=dataSnapshot.child("02-01-2019").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref25000=FirebaseDatabase.getInstance().getReference().child("25000_pzl_2018");
        ref25000.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a_25000=dataSnapshot.child("01-02-2018").getValue().toString();
                b_25000=dataSnapshot.child("02-05-2018").getValue().toString();
                c_25000=dataSnapshot.child("01-08-2018").getValue().toString();
                d_25000=dataSnapshot.child("01-11-2018").getValue().toString();
                a1_25000=dataSnapshot.child("01-02-2019").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ////////////////////////////////////////////////////////////////////
        ref40000=FirebaseDatabase.getInstance().getReference().child("40000_pzl_list");
        ref40000.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a_40000=dataSnapshot.child("1st").getValue().toString();
                b_40000=dataSnapshot.child("2nd").getValue().toString();
                c_40000=dataSnapshot.child("3rd").getValue().toString();
                d_40000=dataSnapshot.child("4th").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ////////////////////////////////////////////////////////////////////////////////
        ref40000pr=FirebaseDatabase.getInstance().getReference().child("40000p_pzl_list");
        ref40000pr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a_40000p=dataSnapshot.child("1st").getValue().toString();
                b_40000p=dataSnapshot.child("2nd").getValue().toString();
                c_40000p=dataSnapshot.child("3rd").getValue().toString();
                d_40000p=dataSnapshot.child("4th").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //spiner 2 coding


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if(spinner2.getSelectedItem().equals(datevalue100_1)){
                    showLoading();
                    getdata_100_1st adress=new getdata_100_1st();
                    adress.m = a;
                    adress.execute();
                    progressDialog1.dismiss();
                }



                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue100_2)) {
                    showLoading();
                    getdata_100_2nd adress=new getdata_100_2nd();
                    adress.m = b;
                    adress.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_1_019)) {
                    showLoading();
                    dataFromWeb adress=new dataFromWeb();
                    adress.m = a1_750;
                    adress.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue_7500_1_019)) {
                    showLoading();
                    dataFromWeb adress=new dataFromWeb();
                    adress.m = a1_7500;
                    adress.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue100_3)) {
                    showLoading();
                    getdata_100_3rd adress=new getdata_100_3rd();
                    adress.m = c;
                    adress.execute();
                    progressDialog1.dismiss();

                }

                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue100_4)) {
                    showLoading();
                    getdata_100_4th adress=new getdata_100_4th();
                    adress.m = d;
                    adress.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue200_1)) {
                    showLoading();
                    getdata_200_1st obj3=new getdata_200_1st();
                    obj3.m = a_200;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue200_4)) {
                    showLoading();
                    getdata_200_4th obj3=new getdata_200_4th();
                    obj3.m = b_200;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datetevalue200_2)) {
                    showLoading();
                    getdata_200_2nd obj3=new getdata_200_2nd();
                    obj3.m = c_200;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue200_3)) {
                    showLoading();
                    getdata_200_3rd obj3=new getdata_200_3rd();
                    obj3.m = d_200;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                //750 1st
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_1)) {
                    showLoading();
                    list_750_1st obj3=new list_750_1st();
                    obj3.m = a_750;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_3)) {
                    showLoading();
                    list_750_3rd obj3=new list_750_3rd();
                    obj3.m = b_750;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_4)) {
                    showLoading();
                    list_750_4th obj3=new list_750_4th();
                    obj3.m = c_750;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_2)) {
                    showLoading();
                    list_750_2nd obj3=new list_750_2nd();
                    obj3.m = d_750;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                //1500
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_1)) {
                    showLoading();
                    list_1500_1st obj3=new list_1500_1st();
                    obj3.m = a_1500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_2)) {
                    showLoading();
                    list_1500_2nd obj3=new list_1500_2nd();
                    obj3.m = b_1500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_3)) {
                    showLoading();
                    list_1500_3rd obj3=new list_1500_3rd();
                    obj3.m = c_1500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_4)) {
                    showLoading();
                    list_1500_4th obj3=new list_1500_4th();
                    obj3.m = d_1500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                //7500
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_1)) {
                    showLoading();
                    list_7500_1st obj3=new list_7500_1st();
                    obj3.m = a_7500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_2)) {
                    showLoading();
                    list_7500_2nd obj3=new list_7500_2nd();
                    obj3.m = b_7500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_3)) {
                    showLoading();
                    list_7500_3rd obj3=new list_7500_3rd();
                    obj3.m = c_7500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_4)) {
                    showLoading();
                    list_7500_4th obj3=new list_7500_4th();
                    obj3.m = d_7500;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                //15000
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue_15000_1_2019)) {
                    showLoading();
                    dataFromWeb obj3 = new dataFromWeb();
                    obj3.m = link_15000_1;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue15000_1)) {
                    showLoading();
                    getdata_15000_1st obj3=new getdata_15000_1st();
                    obj3.m = a_15000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue15000_2)) {
                    showLoading();
                    getdata_15000_2nd obj3=new getdata_15000_2nd();
                    obj3.m = b_15000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue15000_3)) {
                    showLoading();
                    getdata_15000_3rd obj3 = new getdata_15000_3rd();
                    obj3.m = c_15000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue15000_4)) {
                    showLoading();
                    getdata_15000_4th obj3=new getdata_15000_4th();
                    obj3.m = d_15000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                //25000
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_1)) {
                    showLoading();
                    list_25000_1st obj3=new list_25000_1st();
                    obj3.m = a_25000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_2)) {
                    showLoading();
                    list_25000_2nd obj3=new list_25000_2nd();
                    obj3.m = b_25000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_3)) {
                    showLoading();
                    list_25000_3rd obj3=new list_25000_3rd();
                    obj3.m = c_25000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_4)) {
                    showLoading();
                    list_25000_4th obj3=new list_25000_4th();
                    obj3.m = d_25000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue_1_25000_019)) {
                    showLoading();
                    dataFromWeb obj3=new dataFromWeb();
                    obj3.m = a1_25000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }

                ////
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_1)) {
                    showLoading();
                    list_40000_1st obj3=new list_40000_1st();
                    obj3.m = a_40000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                //
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_2)) {
                    showLoading();
                    list_40000_2nd obj3=new list_40000_2nd();
                    obj3.m = b_40000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }

                /////////////////////
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_4)) {
                    showLoading();
                    list_40000_4th obj3=new list_40000_4th();
                    obj3.m = c_40000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                /////////////////
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_3)) {
                    showLoading();
                    list_40000_3rd obj3=new list_40000_3rd();
                    obj3.m = d_40000;
                    obj3.execute();
                    progressDialog1.dismiss();

                }


                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_4)) {
                    showLoading();
                    list_40000p_4th obj3=new list_40000p_4th();
                    obj3.m = a_40000p;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_3)) {
                    showLoading();
                    list_40000p_3rd obj3=new list_40000p_3rd();
                    obj3.m = b_40000p;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_2)) {
                    showLoading();
                    list_40000_2nd obj3=new list_40000_2nd();
                    obj3.m = c_40000p;
                    obj3.execute();
                    progressDialog1.dismiss();

                }
                else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_1)) {
                    showLoading();
                    list_40000p_1st obj3=new list_40000p_1st();
                    obj3.m = d_40000p;
                    obj3.execute();
                    progressDialog1.dismiss();

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //permission for external storage
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M&&checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String []{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }
// UPLOADING BUTTON CDIING
        but_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFile();
            }
        });
        //////////////////END/////////////////////

        //SEARCH CODING ///
        but_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prizebond_data="";
                if(strings.size()==0){
                    Toast.makeText(getApplicationContext(),"PLEASE UPLOAD YOUR FILE FIRST !",Toast.LENGTH_LONG).show();
                }
                else {


                showSearch();
                new CountDownTimer(3000, 3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        progressDialog1.dismiss();
                        if(spinner1.getSelectedItem()!=null&&spinner2.getSelectedItem().equals("Please Select Data")){
                            Toast.makeText(getApplicationContext(), "Enter Valid Information", Toast.LENGTH_SHORT).show();
                        }
                        else if(spinner1.getSelectedItem().equals("Please Select Your Bond")&&spinner2.getSelectedItem().equals("Select Your Prize Bond Date")){
                            Toast.makeText(getApplicationContext(),"Enter Valid Information",Toast.LENGTH_LONG).show();
                        }
                        else {


                            String[] value_2;
                            if (spinner2.getSelectedItem().equals(datevalue100_1)) {
                                value_2 = getdata_100_1st.myvariable1.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            prizebond_data = prizebond_data + "" + value_2[i];
                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }


                            }

                            if (spinner2.getSelectedItem().equals(datevalue_7500_1_019)) {
                                value_2 = dataFromWeb.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            prizebond_data = prizebond_data + "" + value_2[i];
                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }


                            }

//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue100_2)) {
                                value_2 = getdata_100_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + " " + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            ////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue750_1_019)) {
                                value_2 = dataFromWeb.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + " " + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue100_3)) {
                                value_2 = getdata_100_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue100_4)) {
                                value_2 = getdata_100_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue200_1)) {
                                value_2 = getdata_200_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datetevalue200_2)) {
                                value_2 = getdata_200_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue200_3)) {
                                value_2 = getdata_200_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue200_4)) {
                                value_2 = getdata_200_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];
                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue750_1)) {
                                value_2 = list_750_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue750_2)) {
                                value_2 = list_750_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue750_3)) {
                                value_2 = list_750_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue750_4)) {
                                value_2 = list_750_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue7500_1)) {
                                value_2 = list_7500_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue7500_2)) {
                                value_2 = list_7500_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue7500_3)) {
                                value_2 = list_7500_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue7500_4)) {
                                value_2 = list_7500_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //  Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue1500_1)) {
                                value_2 = list_1500_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue1500_2)) {
                                value_2 = list_1500_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //  Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue1500_3)) {
                                value_2 = list_1500_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue1500_4)) {
                                value_2 = list_1500_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue15000_1)) {
                                value_2 = getdata_15000_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }

                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue15000_2)) {
                                value_2 = getdata_15000_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //  Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue15000_3)) {
                                value_2 = getdata_15000_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue15000_4)) {
                                value_2 = getdata_15000_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue25000_1)) {
                                value_2 = list_25000_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue25000_2)) {
                                value_2 = list_25000_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {

                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue25000_3)) {
                                value_2 = list_25000_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue25000_4)) {
                                value_2 = list_25000_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            if (spinner2.getSelectedItem().equals(datevalue_1_25000_019)) {
                                value_2 = dataFromWeb.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000_1)) {
                                value_2 = list_40000_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000_2)) {
                                value_2 = list_40000_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000_3)) {
                                value_2 = list_40000_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            //Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000_4)) {
                                value_2 = list_40000_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000p_1)) {
                                value_2 = list_40000p_1st.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000p_2)) {
                                value_2 = list_40000p_2nd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000p_3)) {
                                value_2 = list_40000p_3rd.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////
                            // //////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue_15000_1_2019)) {
                                value_2 = dataFromWeb.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////
                            if (spinner2.getSelectedItem().equals(datevalue40000p_4)) {
                                value_2 = list_40000p_4th.myvariable.split(" |\\  ");
                                for (int a = 0; a < strings.size(); a++) {
                                    String number = strings.get(a);
                                    for (int i = 0; i < value_2.length; i++) {

                                        if (number.equals(value_2[i])) {
                                            // Toast.makeText(getApplicationContext(), "THE BOND AT THE NUMBER  " + number + "  EXISTS", Toast.LENGTH_LONG).show();
                                            //showMeassage();
                                            prizebond_data = prizebond_data + "" + value_2[i];

                                        }
                                    }
                                }
                                if (prizebond_data != null) {
                                    showData(prizebond_data);
                                    prizebond_data = "";
                                }
                            }
                        }

                    }


                }.start();

            }
            }
        });
        ///////END////////
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"DONE",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public String READDATA(String data){
        File file=new File(Environment.getExternalStorageDirectory(),data);
        StringBuilder stringBuilder=new StringBuilder();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line;
            while((line=bufferedReader.readLine())!=null){
                if(line.length()==6){
                   strings.add(line);
                   stringArrayAdapter_1.notifyDataSetChanged();

                }
                else {
                    strings.remove(line);
                    stringArrayAdapter_1.notifyDataSetChanged();
                    Toast.makeText(this,"PLEASE CHECK YOUR FILE DATA",Toast.LENGTH_LONG).show();
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public void SearchFile(){
        textView.setVisibility(View.INVISIBLE);
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent,2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2&&resultCode==RESULT_OK){
            if(data!=null){
                Uri uri=data.getData();
                String path=uri.getPath();
                path=path.substring(path.indexOf(":")+1);
                if(path.contains("emulated")){
                    path=path.substring(path.indexOf("0")+1);
                }
//                Toast.makeText(this,path,Toast.LENGTH_SHORT).show();
                READDATA(path);
            }
        }
    }
    private void showSearch() {
        progressDialog1=new ProgressDialog(Search_by_file.this);
        // progressDialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog1.setTitle("....Searching the Records....");
        progressDialog1.setMessage("....PLEASE WAIT....");
        progressDialog1.setCancelable(false);
        progressDialog1.show();
    }
    private void showData(String prizebond_data1) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(Search_by_file.this);
        if(prizebond_data1.equals("")){
            builder.setTitle("RESULT");
            builder.setMessage("SORRY TRY NEXT TIME ! BEST OF LUCK");
        }
        else
        {
            builder.setTitle("CONGRATULATION !"+" YOUR BOND EXIST AT");
            builder.setMessage(prizebond_data1+" ");
        }

        builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.setCancelable(true);
            }
        });
        builder.show();
    }
    private void showLoading() {
        progressDialog1=new ProgressDialog(Search_by_file.this);
        progressDialog1.setTitle("....Setting Up Dates....");
        progressDialog1.setMessage("....PLEASE WAIT....");
        progressDialog1.setCancelable(true);
        progressDialog1.show();
    }
}
