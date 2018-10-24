package com.example.jitendrakumarsahu.loginregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextId;

    MyDatabaseAdaptor myDatabaseAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextId = findViewById(R.id.editText_emp_id_reg);
        editTextName = findViewById(R.id.editText_emp_name_reg);
        editTextEmail = findViewById(R.id.editText_email_reg);
        editTextPassword = findViewById(R.id.editText_emp_password_reg);

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        //intent.putExtra(MainActivity.EXTRA_KEY_PARCEL_EMPLOYEE);
        return intent;
    }

    public void addUser(View view)
    {
        String s1 = editTextName.getText().toString();
        String s2 = editTextEmail.getText().toString();
        String s3 = editTextPassword.getText().toString();

        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty() ) {
            Toast.makeText(this, "Name, Age and Salary are Empty!!!!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            myDatabaseAdaptor=new MyDatabaseAdaptor(MainActivity.this);
            long id = myDatabaseAdaptor.insertData(s1, s2, s3);

            if (id <= 0) {
                Toast.makeText(this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                editTextId.setText("");
                editTextName.setText("");
                editTextEmail.setText("");
                editTextPassword.setText("");

            } else {
                Toast.makeText(this, "Insertion Successfull", Toast.LENGTH_SHORT).show();
                editTextId.setText("");
                editTextName.setText("");
                editTextEmail.setText("");
                editTextPassword.setText("");
            }

        }
    }
}
