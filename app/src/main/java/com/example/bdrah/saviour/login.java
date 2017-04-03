package com.example.bdrah.saviour;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener  {
   private EditText Email, Password;
   private Button Login;
   private TextView registerLink;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editText2);
        Login = (Button)findViewById(R.id.button);
        registerLink = (TextView)findViewById(R.id.textView);

        Login.setOnClickListener(this);
        registerLink.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(db.CheckEmailIsDataAlreadyInDBorNot(Email))
            if (db.CheckPassIsDataAlreadyInDBorNot(Password)){

                switch (view.getId()) {
                    case R.id.button:
                        startActivity(new Intent(this, Profile.class));
                        break;

                    case R.id.textView:
                        startActivity(new Intent(this, Register.class));
                        break;


                }
        }
        else{ if(Email.getText() == null )
                Email.setError("Please enter your email");

                if(Password.getText() == null)
                Password.setError("Please enter your password");
            }

        else{
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("wrong password or username");
            dlgAlert.setTitle("Error Message...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        }
    }

