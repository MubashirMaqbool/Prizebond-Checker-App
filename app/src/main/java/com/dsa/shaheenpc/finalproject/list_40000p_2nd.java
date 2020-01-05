package com.dsa.shaheenpc.finalproject;

import android.content.Context;
import android.os.AsyncTask;

import com.google.firebase.database.DatabaseReference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class list_40000p_2nd  extends AsyncTask<Void,Void,Void> {
    String line = "";
    String temp = "";
    static String myvariable="";
    JSONArray jsonArray;
    String[] array = {};
    DatabaseReference databaseReference;
    static String m;
    String sp;
    Context context;
    int i = 0;
    @Override
    protected Void doInBackground(Void... voids) {
        myvariable="";

        try{

            URL obj1 = new URL(m);
            //   Toast.makeText(context, "God i need your help  " + sp, Toast.LENGTH_SHORT).show();

            HttpURLConnection httpURLConnection = (HttpURLConnection) obj1.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String data = "";

            while (data != null) {

                data = bufferedReader.readLine();
                line = line + data;


            }
            jsonArray = new JSONArray(line);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                temp = " " + jsonObject.get("A");
                myvariable = temp + myvariable;


            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
