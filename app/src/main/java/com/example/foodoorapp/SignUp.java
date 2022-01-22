package com.example.foodoorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodoorapp.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button registeredBtn;
    TextView signInTextView;
    EditText fullNameTextView;
    EditText emailTextView;
    EditText passwordTextView;
    EditText confirmPasswordTextView;
    private FirebaseAuth auth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        getSupportActionBar().hide();
        registeredBtn = findViewById(R.id.registeredBtn);
        signInTextView = findViewById(R.id.signInTextView);
        fullNameTextView = findViewById(R.id.fullName);
        emailTextView = findViewById(R.id.loginEmailText);
        passwordTextView = findViewById(R.id.passwordTextView);
        confirmPasswordTextView = findViewById(R.id.loginPasswordText);

        registeredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameTextView.getText().toString();
                String email = emailTextView.getText().toString();
                String password = passwordTextView.getText().toString();
                String confirmPassword = confirmPasswordTextView.getText().toString();
                boolean isValid = isValidData(fullName,email,password,confirmPassword);
                if(isValid==true)
                {
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isComplete())
                            {
                                User user = new User(fullName, email, password);
                                database.getReference().child("User").setValue(user);
                                Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Email Already Registered", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Data",Toast.LENGTH_LONG).show();
                }
            }
        });
        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
    private boolean isValidData(String fullName, String email, String password, String confirmPassword)
    {
        if (fullName.equals(""))
        {
            return false;
        }
        if(password.equals(confirmPassword)==false)
        {
            return false;
        }
        return true;
    }

}