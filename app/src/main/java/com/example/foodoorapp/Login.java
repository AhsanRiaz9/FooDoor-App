package com.example.foodoorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class Login extends AppCompatActivity {
//    Firebase auth
    private FirebaseAuth auth;
    private Button loginBtn;
    private TextView signUpTextView;
    private EditText loginEmailText;
    private EditText loginPasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        // firebase auth
        auth = FirebaseAuth.getInstance();
        // email password text
        loginEmailText = findViewById(R.id.loginEmailText);
        loginPasswordText = findViewById(R.id.loginPasswordText);
        loginBtn = findViewById(R.id.loginBtn);
        signUpTextView = findViewById(R.id.signUpTextView);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmailText.getText().toString();
                String password = loginPasswordText.getText().toString();
//                Toast.makeText(getApplicationContext(), email + " " + password, Toast.LENGTH_SHORT).show();
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),  "Login Successful", Toast.LENGTH_SHORT).show();
                            email.toLowerCase();
                            if(email.equals("ahsanriaz@gmail.com")==true)
                            {
                                Intent intent = new Intent(getApplicationContext(),AdminDashboard.class);
                                startActivity(intent);
                            }
                            else {
                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Login Failure", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });

    }
}