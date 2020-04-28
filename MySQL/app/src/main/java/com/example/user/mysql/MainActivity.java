package com.example.user.mysql;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,age,gender,phone,email;
    FloatingActionButton insertButton;
    SQLiteDatabase myDb;
    Button button1;



    String CreatingOrOpenTable="CREATE TABLE IF NOT EXISTS "+
            "tblGrace "+
            "(name varchar, "+
            "age varchar, "+
            "gender varchar, "+
            "phone varchar, "+
            "email varchar); ";

    String sname,sage,sphone,semail,sgender;
    public static String tableName="Grace";
    public static String col1="name";
    public static String col2="age";
    public static String col3="gender";
    public static String col4="phonenumber";
    public static String col5="email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        gender=(EditText)findViewById(R.id.gender);
        insertButton=(FloatingActionButton)findViewById(R.id.floating);
        button1=(Button)findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RetrieveData.class);
                startActivity(intent);
            }
        });

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname=name.getText().toString();
                sage=age.getText().toString();
                sgender=gender.getText().toString();
                sphone=phone.getText().toString();
                semail=email.getText().toString();

                saveData(sname,sage,sphone,semail,sgender);

                reset();

            }
        });
    }

    public void saveData(String name,String age,String phone,String email,String gender){
        try{
            myDb=openOrCreateDatabase("zalego", Context.MODE_PRIVATE,null);
            try{
                myDb.execSQL(CreatingOrOpenTable);
            }catch(Exception e){
                Log.e("Error","in........");
            }try{
                myDb.execSQL("INSERT INTO " +
                        "tblGrace "+
                        "VALUES(" +
                        "'" +name+"', "+
                        "'" +age+"', "+
                        "'" +gender+"', "+
                        "'" +phone+"', "+
                        "'" +email+"');");

                Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();

            }catch (Exception error){
                Log.e("Error","inserting in the database");
            }
        }catch (Exception error){
            error.printStackTrace();
            reset();
        }
    }

    public void reset(){
        name.setText("");
        age.setText("");
        phone.setText("");
        email.setText("");
        gender.setText("");
    }
}
