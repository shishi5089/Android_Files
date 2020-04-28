package com.example.user.mysql;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateRecords extends AppCompatActivity {

    TextView nameOfUser;
    EditText editPhoneNumber,editEmail;
    Button updateRecord;
    SQLiteDatabase mydb;
    Updater updateValues;

    String updName,updPhone,updEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_records);

        nameOfUser=(TextView)findViewById(R.id.updateName);
        editPhoneNumber=(EditText)findViewById(R.id.updatePhone);
        editEmail=(EditText)findViewById(R.id.updateEmail);
        updateRecord=(Button)findViewById(R.id.updateInfo);

        Updater updateValues=new Updater();
        nameOfUser.setText(updateValues.getUserName());
        editPhoneNumber.setText(updateValues.getUserPhoneNumber());
        editEmail.setText(updateValues.getUserEmail());

        updName=nameOfUser.getText().toString();
        updPhone=editPhoneNumber.getText().toString();
        updEmail=editEmail.getText().toString();

        updateRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateRow(updName,updPhone,updEmail);
                Intent intent=new Intent(UpdateRecords.this,RetrieveData.class);
            }
        });

    }

    public void UpdateRow(String name,String phone,String email){
        mydb=openOrCreateDatabase("zalego", Context.MODE_PRIVATE,null);

        ContentValues values=new ContentValues();
        values.put("phone",phone);
        values.put("email",email);


        mydb.update("tblGrace",values,"name=?",new String[]{name});
    }
}
