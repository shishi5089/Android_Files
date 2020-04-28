package com.example.user.mysql;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class RetrieveData extends AppCompatActivity {

    ListView list1;
    FloatingActionButton insertNewData;
    SQLiteDatabase mydb;
    String[]names,ages,genders,phonenumbers,emails;


    String CreatingOrOpenTable="CREATE TABLE IF NOT EXISTS "+
            "tblGrace "+
            "(name varchar, "+
            "age varchar, "+
            "gender varchar, "+
            "phone varchar, "+
            "email varchar); ";

    String user_PhoneNumber;
   String selectedUser;
    String senderEmail;
    String user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data);

        list1=(ListView)findViewById(R.id.list);
        insertNewData=(FloatingActionButton)findViewById(R.id.floating1);
        getData();

//        list1.setAdapter(new CustomAdapter(this, names, ages, genders, phonenumbers, emails));
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String username,userphone,useremail;
                username=((TextView)view.findViewById(R.id.text1)).getText().toString();
                userphone=((TextView)view.findViewById(R.id.text5)).getText().toString();
                useremail=((TextView)view.findViewById(R.id.text4)).getText().toString();

                createUserPopup(userphone,username,useremail);

            }
        });

        insertNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RetrieveData.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void getData(){
        try{
            mydb=openOrCreateDatabase("zalego", Context.MODE_PRIVATE,null);
            try{
                mydb.execSQL(CreatingOrOpenTable);
            }catch (Exception error){
                Log.e("Error", "in opening the table");
            }
            try{
                Cursor cursor=mydb.rawQuery("SELECT * from tblGrace",null);

                if(cursor.moveToFirst()){
                    names=new String[cursor.getCount()];
                    ages=new String[cursor.getCount()];
                    genders=new String[cursor.getCount()];
                    phonenumbers=new String[cursor.getCount()];
                    emails=new String[cursor.getCount()];


                }
                int i=0;
                do{
                    names[i]=cursor.getString(0);
                    ages[i]=cursor.getString(1);
                    genders[i]=cursor.getString(2);
                    phonenumbers[i]=cursor.getString(3);
                    emails[i]=cursor.getString(4);

                    i++;

                }while(cursor.moveToNext());
                list1.setAdapter(new CustomAdapter(this, names, ages, genders, phonenumbers, emails));
            }catch(Exception error){
                Log.e("Error", "in retrieving data");

            }
        }catch (Exception error){
            error.printStackTrace();
        }
    }

    public void createUserPopup(String phonex,String namex,String emailx){

        LayoutInflater layoutInflater=LayoutInflater.from(RetrieveData.this);

        View promptPop=layoutInflater.inflate(R.layout.popuplayout, null);
        TextView text_name=(TextView)promptPop.findViewById(R.id.popUser);
        TextView text_phone=(TextView)promptPop.findViewById(R.id.popPhone);
        TextView text_email=(TextView)promptPop.findViewById(R.id.popEmail);

        text_name.setText(namex);
        text_email.setText(emailx);
        text_phone.setText(phonex);


       user_PhoneNumber= phonex;
       selectedUser=namex;


        AlertDialog.Builder alertDialogBox=new AlertDialog.Builder(this);
                alertDialogBox.setView(promptPop);

        alertDialogBox.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + user_PhoneNumber));
                startActivity(callIntent);
                */
                deleteItem(selectedUser);
                recreate();
            }
        });

        alertDialogBox.setNegativeButton("UPDATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                updateThisInformation();
            }
        });


        alertDialogBox.setPositiveButton("EMAIL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent sendMailIntent=new Intent(Intent.ACTION_SEND);
                sendMailIntent.setData(Uri.parse("email"));
                sendMailIntent.putExtra(Intent.EXTRA_EMAIL,senderEmail);
                sendMailIntent.putExtra(Intent.EXTRA_SUBJECT,"this is to subject");
                sendMailIntent.putExtra(Intent.EXTRA_TEXT, "message part");
                sendMailIntent.setType("message/rfc822");
                Intent chooserApplication=Intent.createChooser(sendMailIntent,"Launch email");
                startActivity(chooserApplication);
            }
        });


        alertDialogBox.show();




    }

    public void deleteItem(String name1){
        mydb=openOrCreateDatabase("zalego",Context.MODE_PRIVATE,null);

        try{
            mydb.execSQL(CreatingOrOpenTable);
            getData();

        }catch(Exception error){
            error.printStackTrace();
            Log.e("error", "in deleting item");
        }
        try{
            mydb.execSQL("DELETE FROM tblGrace WHERE name ='"+name1+"'");
        }catch(Exception error) {
            error.printStackTrace();
            Log.e("error", "in deleting item");
        }
    }

    public void updateThisInformation(){
        Updater updateValues=new Updater();
        updateValues.setUserName(selectedUser);
        updateValues.setUserPhoneNumber(user_PhoneNumber);
        updateValues.setUserEmail(user_email);


        Intent intent=new Intent(RetrieveData.this,UpdateRecords.class);
        startActivity(intent);
    }

}
