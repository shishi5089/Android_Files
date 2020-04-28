package com.example.user.bankingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView bank;
    EditText name,pass,confirm;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bank=(TextView)findViewById(R.id.bank);
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        confirm=(EditText)findViewById(R.id.confirm);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goHome=new Intent(MainActivity.this,Home.class);
                MainActivity.this.startActivity(goHome);


            }
        });
    }
}
