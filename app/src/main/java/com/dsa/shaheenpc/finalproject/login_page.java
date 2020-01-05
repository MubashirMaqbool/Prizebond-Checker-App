package com.dsa.shaheenpc.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dsa.shaheenpc.finalproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_page extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText email, password;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        email = (EditText) findViewById(R.id.mail1);
        password = (EditText) findViewById(R.id.pass1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><i>LOGIN YOURSELF</i></font>"));
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getInstance().getCurrentUser() != null) {
            // finish();
            Intent intent = new Intent(getApplicationContext(), dash_board.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadout);
        }

        //

    }

    public void create_account_activity(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), create_account.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fleft, R.anim.fhelper);

    }

    public void Login(View view) {
        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Something Went Wrong !", Toast.LENGTH_SHORT).show();
        } else {
            //progress bar//
            progressDialog = new ProgressDialog(login_page.this);
            progressDialog.setTitle("....Workig....");
            progressDialog.setMessage("PLEASE WAIT....");
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        finish();
                        Intent intent = new Intent(getApplicationContext(), dash_board.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Something Went Wrong !", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }


}