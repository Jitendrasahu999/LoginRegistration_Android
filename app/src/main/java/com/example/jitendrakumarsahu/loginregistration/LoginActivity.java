package com.example.jitendrakumarsahu.loginregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button btnLogin;
    Button btnReset;
    Button btnRegistration;

    MyDatabaseAdaptor myDatabaseAdaptor;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDatabaseAdaptor=new MyDatabaseAdaptor(LoginActivity.this);
        editTextEmail = findViewById(R.id.editText_emp_email);
        editTextPassword = findViewById(R.id.editText_emp_password);
        btnLogin = findViewById(R.id.button_login);
        btnReset = findViewById(R.id.button_reset);

        btnRegistration = findViewById(R.id.button_Registration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = MainActivity.getStartIntent(LoginActivity.this);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseAdaptor = new MyDatabaseAdaptor(LoginActivity.this);
                boolean employees = myDatabaseAdaptor.checkUser(editTextEmail.getText().toString(),editTextPassword.getText().toString());
                Toast.makeText(LoginActivity.this, "emp"+employees, Toast.LENGTH_SHORT).show();
                if(employees == true){
                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        
    }

}
