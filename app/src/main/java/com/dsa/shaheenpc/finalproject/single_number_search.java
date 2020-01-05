package com.dsa.shaheenpc.finalproject;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dsa.shaheenpc.finalproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class single_number_search extends AppCompatActivity {
    Spinner spinner1,spinner2;
    String a,b,c,d;
    String a_200,b_200,c_200,d_200="";
    String a_750,b_750,c_750,d_750,a1_750="";
    String a_1500,b_1500,c_1500,d_1500="";
    String a_7500,b_7500,c_7500,d_7500,a1_7500="";
    String a_15000,b_15000,c_15000,d_15000,link_15000_1="";
    String a_25000,b_25000,c_25000,d_25000,a1_25000="";
    String a_40000,b_40000,c_40000,d_40000="";
    String a_40000p,b_40000p,c_40000p,d_40000p="";
    static EditText editText1;
    ProgressDialog progressDialog1;
    int found=0;
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
    String[] value;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          if(item.getItemId()==R.id.action_settings){
              finish();
              Intent intent=new Intent(this,Database_record.class);
              startActivity(intent);
              overridePendingTransition(R.anim.fleft, R.anim.fhelper);
          }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_scrolling, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_number_search);
       android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><i>Search Your Bond</i></font>"));
        dataBase=new DataBase(this);
        db = dataBase.getReadableDatabase();
        spinner1 = (Spinner) findViewById(R.id.sp1);
        spinner2 = (Spinner) findViewById(R.id.sp2);
        editText1=(EditText)findViewById(R.id.editText);
        String[] item1=new String[]{"Select Your Prize Bond Date","Please ! Fisrt Select Your Bond Type"};
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(single_number_search.this,android.R.layout.simple_list_item_1,item1);
        spinner2.setAdapter(stringArrayAdapter);
        String[] item = new String[]{"Please Select Your Bond","100", "200", "750","1500","7500","15000","25000","40000","40000 Premium"};
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, item);
        spinner1.setAdapter(adapters);

      //////////////////////////////////////////////////
        //spinner coding
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          String[] items = new String[]{"Please Select Data",datevalue_1_25000_019,datevalue25000_1, datevalue25000_2, datevalue25000_3, datevalue25000_4};
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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
                          ArrayAdapter<String> adapter = new ArrayAdapter<String>(single_number_search.this, android.R.layout.simple_spinner_dropdown_item, items);
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


        //set the spinners adapter to the previously created one.

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
                      getdata_100_1st obj1 = new getdata_100_1st();
                      obj1.m = a;
                      obj1.execute();
                      progressDialog1.dismiss();
                  }

                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue_7500_1_019)) {
                      showLoading();
                      dataFromWeb obj = new dataFromWeb();
                      obj.m =a1_7500 ;
                      obj.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_1_019)) {
                      showLoading();
                      dataFromWeb obj = new dataFromWeb();
                      obj.m =a1_750 ;
                      obj.execute();
                      progressDialog1.dismiss();

                  }

               else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue100_2)) {
                      showLoading();
                    getdata_100_2nd obj = new getdata_100_2nd();
                    obj.m = b;
                    obj.execute();
                    progressDialog1.dismiss();

                }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue100_3)) {
                      showLoading();
                      getdata_100_3rd obj2 = new getdata_100_3rd();
                      obj2.m = c;
                      obj2.execute();
                      progressDialog1.dismiss();

                  }

                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue100_4)) {
                      showLoading();
                      getdata_100_4th obj3 = new getdata_100_4th();
                      obj3.m = d;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue200_1)) {
                      showLoading();
                      getdata_200_1st obj3 = new getdata_200_1st();
                      obj3.m = a_200;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue200_4)) {
                      showLoading();
                      getdata_200_2nd obj3 = new getdata_200_2nd();
                      obj3.m = b_200;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datetevalue200_2)) {
                      showLoading();
                      getdata_200_3rd obj3 = new getdata_200_3rd();
                      obj3.m = c_200;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue200_3)) {
                      showLoading();
                      getdata_200_4th obj3 = new getdata_200_4th();
                      obj3.m = d_200;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  //750 1st
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_1)) {
                      showLoading();
                      list_750_1st obj3 = new list_750_1st();
                      obj3.m = a_750;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_3)) {
                      showLoading();
                      list_750_2nd obj3 = new list_750_2nd();
                      obj3.m = b_750;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_4)) {
                      showLoading();
                      list_750_3rd obj3 = new list_750_3rd();
                      obj3.m = c_750;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue750_2)) {
                      showLoading();
                      list_750_4th obj3 = new list_750_4th();
                      obj3.m = d_750;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  //1500
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_1)) {
                      showLoading();
                      list_1500_1st obj3 = new list_1500_1st();
                      obj3.m = a_1500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_2)) {
                      showLoading();
                      list_1500_2nd obj3 = new list_1500_2nd();
                      obj3.m = b_1500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_3)) {
                      showLoading();
                      list_1500_3rd obj3 = new list_1500_3rd();
                      obj3.m = c_1500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue1500_4)) {
                      showLoading();
                      list_1500_4th obj3 = new list_1500_4th();
                      obj3.m = d_1500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  //7500
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_1)) {
                      showLoading();
                      list_7500_1st obj3 = new list_7500_1st();
                      obj3.m = a_7500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_2)) {
                      showLoading();
                      list_7500_2nd obj3 = new list_7500_2nd();
                      obj3.m = b_7500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_3)) {
                      showLoading();
                      list_7500_3rd obj3 = new list_7500_3rd();
                      obj3.m = c_7500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue7500_4)) {
                      showLoading();
                      list_7500_4th obj3 = new list_7500_4th();
                      obj3.m = d_7500;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  //15000
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue15000_1)) {
                      showLoading();
                      getdata_15000_1st obj3 = new getdata_15000_1st();
                      obj3.m = a_15000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue15000_2)) {
                      showLoading();
                      getdata_15000_2nd obj3 = new getdata_15000_2nd();
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
                      getdata_15000_4th obj3 = new getdata_15000_4th();
                      obj3.m = d_15000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  /////
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue_15000_1_2019)) {
                      showLoading();
                      dataFromWeb obj3 = new dataFromWeb();
                      obj3.m = link_15000_1;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  //25000
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_1)) {
                      showLoading();
                      list_25000_1st obj3 = new list_25000_1st();
                      obj3.m = a_25000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_2)) {
                      showLoading();
                      list_25000_2nd obj3 = new list_25000_2nd();
                      obj3.m = b_25000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_3)) {
                      showLoading();
                      list_25000_3rd obj3 = new list_25000_3rd();
                      obj3.m = c_25000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue25000_4)) {
                      showLoading();
                      list_25000_4th obj3 = new list_25000_4th();
                      obj3.m = d_25000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue_1_25000_019)) {
                      showLoading();
                      dataFromWeb obj3 = new dataFromWeb();
                      obj3.m = a1_25000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }

                  ////
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_1)) {
                      showLoading();
                      list_40000_1st obj3 = new list_40000_1st();
                      obj3.m = a_40000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  //
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_2)) {
                      showLoading();
                      list_40000_2nd obj3 = new list_40000_2nd();
                      obj3.m = b_40000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }

                  /////////////////////
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_4)) {
                      showLoading();
                      list_40000_3rd obj3 = new list_40000_3rd();
                      obj3.m = c_40000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  /////////////////
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000_3)) {
                      showLoading();
                      list_40000_4th obj3 = new list_40000_4th();
                      obj3.m = d_40000;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }


                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_4)) {
                      showLoading();
                      list_40000p_1st obj3 = new list_40000p_1st();
                      obj3.m = d_40000p;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_2)) {
                      showLoading();
                      list_40000p_2nd obj3 = new list_40000p_2nd();
                      obj3.m = b_40000p;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_3)) {
                      showLoading();
                      list_40000p_3rd obj3 = new list_40000p_3rd();
                      obj3.m = c_40000p;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }
                  else if (String.valueOf(spinner2.getSelectedItem()).equals(datevalue40000p_1)) {
                      showLoading();
                      list_40000p_4th obj3 = new list_40000p_4th();
                      obj3.m = a_40000p;
                      obj3.execute();
                      progressDialog1.dismiss();

                  }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void showLoading() {
        progressDialog1=new ProgressDialog(single_number_search.this);
        progressDialog1.setTitle("....Setting Up Dates....");
        progressDialog1.setMessage("....PLEASE WAIT....");
        progressDialog1.setCancelable(true);
        progressDialog1.show();
    }

    public void Serch_Button(View view) {
found=0;
       showSearch();
        new CountDownTimer(3000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressDialog1.dismiss();
                String[] value_2;
                if (editText1.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
                }
                else  if(editText1.getText().toString().length()<6 || editText1.getText().toString().length()>6){
                   Toast.makeText(getApplicationContext(),"Enter Valid Number",Toast.LENGTH_LONG).show();
                }
               else if(spinner1.getSelectedItem()!=null&&spinner2.getSelectedItem().equals("Please Select Data")){
                    Toast.makeText(getApplicationContext(), "Enter Valid Information", Toast.LENGTH_SHORT).show();
                }
                else  if(spinner1.getSelectedItem().equals("Please Select Your Bond")&&spinner2.getSelectedItem().equals("Select Your Prize Bond Date")){
                    Toast.makeText(getApplicationContext(),"Enter Valid Information",Toast.LENGTH_LONG).show();
                }
                //
                //  Toast.makeText(getApplicationContext(), "Value Found " + b, Toast.LENGTH_LONG).show();
                else {
                    boolean information= dataBase.InserData(editText1.getText().toString());
                    if (spinner2.getSelectedItem().equals(datevalue100_1)) {
                        value_2 = getdata_100_1st.myvariable1.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {

                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                //showMeassage();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue100_2)) {
                        value_2 = getdata_100_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {

                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue750_1_019)) {
                        value_2 = dataFromWeb.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {

                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////

                    if (spinner2.getSelectedItem().equals(datevalue_7500_1_019)) {
                        value_2 = dataFromWeb.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {

                            if (String.valueOf(editText1.getText()).equals(value_2[i])||String.valueOf(editText1.getText()).equals("477399")) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }

                    ////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue100_3)) {
                        value_2 = getdata_100_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            found = 1;
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue100_4)) {
                        value_2 = getdata_100_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue200_1)) {

                        value_2 = getdata_200_1st.myvariable.split(" |\\  ");


                      //  Toast.makeText(getApplicationContext(), "Method executed", Toast.LENGTH_LONG).show();
                        for (int i = 0; i < value_2.length; i++) {
                            //      Toast.makeText(getApplicationContext(),"Loop executed",Toast.LENGTH_LONG).show();
                            Log.i("the value", value_2[i]);
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue200_4)) {
                        value_2 = getdata_200_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datetevalue200_2)) {
                        value_2 = getdata_200_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue200_3)) {
                        value_2 = getdata_200_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ///////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue750_1)) {
                        value_2 = list_750_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue750_3)) {
                        value_2 = list_750_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue750_4)) {
                        value_2 = list_750_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue750_2)) {
                        value_2 = list_750_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //////////////////////////////////////////////1500 has started/////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue1500_1)) {
                        value_2 = list_1500_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue1500_2)) {
                        value_2 = list_1500_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue1500_3)) {
                        value_2 = list_1500_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue1500_4)) {
                        value_2 = list_1500_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //7500
                    if (spinner2.getSelectedItem().equals(datevalue7500_1)) {
                        value_2 = list_7500_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue7500_2)) {
                        value_2 = list_7500_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue7500_3)) {
                        value_2 = list_7500_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue7500_4)) {
                        value_2 = list_7500_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //15000
                    if (spinner2.getSelectedItem().equals(datevalue15000_1)) {
                        value_2 = getdata_15000_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);
                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue15000_2)) {
                        value_2 = getdata_15000_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue15000_3)) {
                        value_2 = getdata_15000_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue15000_4)) {
                        value_2 = getdata_15000_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //25000
                    if (spinner2.getSelectedItem().equals(datevalue25000_1)) {
                        value_2 = list_25000_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue15000_4)) {
                        value_2 = getdata_15000_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    //25000
                    if (spinner2.getSelectedItem().equals(datevalue_15000_1_2019)) {
                        value_2 = dataFromWeb.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue25000_2)) {
                        value_2 = list_25000_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue25000_3)) {
                        value_2 = list_25000_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue25000_4)) {
                        value_2 = list_25000_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue_1_25000_019)) {
                        value_2 = dataFromWeb.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000_1)) {
                        value_2 = list_40000_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
//////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000_2)) {
                        value_2 = list_40000_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000_4)) {
                        value_2 = list_40000_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ///////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000_3)) {
                        value_2 = list_40000_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    /////////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000p_4)) {
                        value_2 = list_40000p_1st.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ///////////////////////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000p_3)) {
                        value_2 = list_40000p_2nd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    if (spinner2.getSelectedItem().equals(datevalue40000p_2)) {
                        value_2 = list_40000p_3rd.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }
                    ///////////////////////////////////////////////
                    if (spinner2.getSelectedItem().equals(datevalue40000p_1)) {
                        value_2 = list_40000p_4th.myvariable.split(" |\\  ");
                        for (int i = 0; i < value_2.length; i++) {
                            if (String.valueOf(editText1.getText()).equals(value_2[i])) {
                                found = 1;
                                Toast.makeText(getApplicationContext(), " " + value_2[i], Toast.LENGTH_LONG).show();
                                showM1(value_2[i]);

                            }
                        }
                    }

                }
                showM2();
                 }

        }.start();

        //editText1.setText("");

                            }

    private void showSearch() {
        progressDialog1=new ProgressDialog(single_number_search.this);
        progressDialog1.setTitle("....Searching the Records....");
        progressDialog1.setMessage("....PLEASE WAIT....");
        progressDialog1.setCancelable(true);
        progressDialog1.show();
    }


    private void showM1(String bond_number) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(single_number_search.this);
            View view = LayoutInflater.from(single_number_search.this).inflate(R.layout.layput, null);
            TextView msg = (TextView) view.findViewById(R.id.msg);
            TextView msg1 = (TextView) view.findViewById(R.id.msg1);
            TextView title = (TextView) view.findViewById(R.id.title);
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);
            if(bond_number.equals("281265 ")||bond_number.equals("449000")||bond_number.equals("227672 ")||bond_number.equals("786640")||
                    bond_number.equals("817984")||bond_number.equals("589439")||bond_number.equals("156055")||bond_number.equals("598752")||bond_number.equals("629636")
                    ||bond_number.equals("082423")||bond_number.equals("374125")||bond_number.equals("963916")||bond_number.equals("635576")
                    ||bond_number.equals("015507")||bond_number.equals("822591")||bond_number.equals("060417")||bond_number.equals("004385")||bond_number.equals("286810")||bond_number.equals("878375")
                    ||bond_number.equals("594975") || bond_number.equals("477399") || bond_number.equals("389896") || bond_number.equals("264322") || bond_number.equals("550288")
                    ||bond_number.equals("545525") || bond_number.equals("840873") || bond_number.equals("046218") || bond_number.equals("811271") || bond_number.equals("658044")|| bond_number.equals("037514")
                    ||bond_number.equals("429168") ||bond_number.equals("668593") || bond_number.equals("680868")|| bond_number.equals("308812") || bond_number.equals("656277") ||bond_number.equals("434303")
                    || bond_number.equals("467508") || bond_number.equals("888764") || bond_number.equals("550275")

         ){
                msg.setText("Bond Number ::"+bond_number);
                msg1.setText("..You have won First Prize..");
            }
            else if(bond_number.equals("021410")||bond_number.equals("390120")||bond_number.equals(" 517366")||
                    bond_number.equals(" 688323")||bond_number.equals("793404")||bond_number.equals(" 944454")||
                    bond_number.equals("699360")||bond_number.equals("742472")||bond_number.equals("947283")||
                    bond_number.equals("147056 ")||bond_number.equals("374427")||bond_number.equals("780469")||
                    bond_number.equals("430351 ")||bond_number.equals("520366")||bond_number.equals("538174  ")
                    ||
                    bond_number.equals("570991")||bond_number.equals("915757")||bond_number.equals("270554")
                    ||
                    bond_number.equals("328344")||bond_number.equals("352099")||bond_number.equals("495788")
                    ||
                    bond_number.equals("894784")||bond_number.equals("007062")||bond_number.equals("184113")
                    ||
                    bond_number.equals("187904")||bond_number.equals("515181")||bond_number.equals("861181")

                    ||
                    bond_number.equals("035474")||bond_number.equals("172997")||bond_number.equals("202532")
                    ||
                    bond_number.equals("425987")||bond_number.equals("661011")

                    ||
                    bond_number.equals("177661")||bond_number.equals("786994")||bond_number.equals("953433")
                    ||
                    bond_number.equals("121611")||bond_number.equals("223172")||bond_number.equals("553151")
                    ||
                    bond_number.equals("096651")||bond_number.equals("678838")||bond_number.equals("835627")
                    ||
                    bond_number.equals("006662")||bond_number.equals("554796")||bond_number.equals("958183")
                    ||
                    bond_number.equals("180469")||bond_number.equals("384302")||bond_number.equals("611891")

                    ||
                    bond_number.equals("068264")||bond_number.equals("466734")||bond_number.equals("581852")
                    ||
                    bond_number.equals("450182")||bond_number.equals("507503")||bond_number.equals("768603")
                    ||
                    bond_number.equals("577579")||bond_number.equals("601042")||bond_number.equals("923327")
                    ||
                    bond_number.equals("354086")||bond_number.equals("617702")||bond_number.equals("978482")

                    ||
                    bond_number.equals("457232")||bond_number.equals("634726")||bond_number.equals("921084")
                    ||
                    bond_number.equals("019084")||bond_number.equals("270596")||bond_number.equals("683074")
                    ||
                    bond_number.equals("491836")||bond_number.equals("536363")||bond_number.equals("661127")
                    ||
                    bond_number.equals("264426")||bond_number.equals("405666")||bond_number.equals("622258")
                    ||
                    bond_number.equals("033988")||bond_number.equals("211290")||bond_number.equals("439491")

                    ||
                    bond_number.equals("196633")||bond_number.equals("346945")||bond_number.equals("365936")
                    ||
                    bond_number.equals("501290")||bond_number.equals("546973")||bond_number.equals("779078")
                    ||
                    bond_number.equals("031693")||bond_number.equals("204348")||bond_number.equals("636774")
                    ||
                    bond_number.equals("325798")||bond_number.equals("339809")||bond_number.equals("997942")
                    ||
                    bond_number.equals("082867")||bond_number.equals("296919")||bond_number.equals("311272")

                    ||
                    bond_number.equals("167993")||bond_number.equals("458710")||bond_number.equals("785204")
                    ||
                    bond_number.equals("075841")||bond_number.equals("366531")||bond_number.equals("919382")
                    ||
                    bond_number.equals("342317")||bond_number.equals("865870")||bond_number.equals("958157")
                    ||
                    bond_number.equals("408684")||bond_number.equals("507018")||bond_number.equals("859416")
                    ||
                    bond_number.equals("581055")||bond_number.equals("769672")||bond_number.equals("775572")

                    ||
                    bond_number.equals("066573")||bond_number.equals("450097")||bond_number.equals("636135")
                    ||
                    bond_number.equals("151883")||bond_number.equals("347924")||bond_number.equals("831873")
                    ||
                    bond_number.equals("164758")||bond_number.equals("250209")||bond_number.equals("344250")
                    ||
                    bond_number.equals("170191")||bond_number.equals("644203")||bond_number.equals("833081")

                    ||
                    bond_number.equals("153744")||bond_number.equals("695422")||bond_number.equals("913633")
                    ||
                    bond_number.equals("018472")||bond_number.equals("739879")||bond_number.equals("779423")
                    ||
                    bond_number.equals("086866")||bond_number.equals("087033")||bond_number.equals("427609")
                    ||
                    bond_number.equals("023961")||bond_number.equals("519469")||bond_number.equals("931526")
                    ){
                msg.setText("Bond Number ::"+bond_number);
                msg1.setText("..You have won 2nd Prize..");
            }
            else {
                msg.setText("Bond Number :: "+bond_number);
                msg1.setText("..You have won 3rd prize..");

            }

            msg.setText(bond_number);
            title.setText("Congratulation");
            found = 12;
            imageButton.setImageResource(R.drawable.ic_beenhere_black_24dp);
            builder.setView(view);
            builder.show();


    }
    private void showM2() {
        if(found!=12) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(single_number_search.this);
            View view = LayoutInflater.from(single_number_search.this).inflate(R.layout.layput, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView msg = (TextView) view.findViewById(R.id.msg);
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);
            title.setText("Sorry ! Try Next Time");
            msg.setText("TRY NEXT TIME ! BEST OF LUCK");
            imageButton.setImageResource(R.drawable.ic_error_black_24dp);
            builder.setView(view);
            builder.show();
        }
    }





/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

