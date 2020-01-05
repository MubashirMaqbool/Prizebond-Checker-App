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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create_account extends AppCompatActivity {
    EditText name,email,phone,password;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><i>Create Account</i></font>"));
        name=(EditText) findViewById(R.id.name);
        email=(EditText)findViewById(R.id.mail);
        phone=(EditText)findViewById(R.id.phone);
        password=(EditText)findViewById(R.id.pass);
        //firebase code//
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
    }

   // create account
    public void CreateAccount(View view){
        if(name.getText().toString().isEmpty()|| email.getText().toString().isEmpty()||phone.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
            Toast.makeText(this,"Please Fill All Fields !",Toast.LENGTH_SHORT).show();

        }else{
            //progress bar
            progressDialog=new ProgressDialog(create_account.this);
            progressDialog.setTitle("....Workig....");
            progressDialog.setMessage("PLEASE WAIT....");
            progressDialog.show();
                 firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        databaseReference=firebaseDatabase.getReference("Users").child(firebaseAuth.getCurrentUser().getUid());
                                        databaseReference.child("Name").setValue(name.getText().toString());
                                        databaseReference.child("Email").setValue(email.getText().toString());
                                        databaseReference.child("Phone").setValue(phone.getText().toString());
                                        databaseReference.child("Password").setValue(password.getText().toString());
                                        progressDialog.dismiss();
                                        Toast.makeText(getApplicationContext(),"Congratulation ",Toast.LENGTH_SHORT).show();
                                        finish();
                                        Intent intent=new Intent(getApplicationContext(),dash_board.class);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.fadein, R.anim.fadout);
                                    }
                                    else  if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(getApplicationContext(),"Your Account has been taken",Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                    }

                                    else{
                                        Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                    }
                     }
                 });
        }

    }
}