package com.example.user.contactretriever;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    SearchView searchItems;
    ArrayList<SelectUser> contactArray;
    CustomAdapter adapter;
    ContentResolver resolver;
    Cursor contactInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.list);

        searchItems=(SearchView)findViewById(R.id.searchItems);

        resolver=this.getContentResolver();

        contactArray=new ArrayList<SelectUser>();

        contactInformation=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

        LoadContacts loadContacts=new LoadContacts();
        loadContacts.execute();


    }
    public class LoadContacts extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }



        @Override
        protected Void doInBackground(Void... params) {
            if(contactInformation!=null){
                Toast.makeText(MainActivity.this,"loading "+contactInformation.getCount(),Toast.LENGTH_LONG).show();
            }
            do{
                Bitmap bitmap=null;
                String phoneNumber,contactName,thumbNail;
                phoneNumber=contactInformation.getString(contactInformation.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactName=contactInformation.getString(contactInformation.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                thumbNail=contactInformation.getString(contactInformation.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI));

                try{
                    if(thumbNail !=null){
                        bitmap= MediaStore.Images.Media.getBitmap(resolver, Uri.parse(thumbNail));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SelectUser userData=new SelectUser();
                userData.setPhoneNumber(phoneNumber);
                userData.setUserName(contactName);
                userData.setBitmap(bitmap);

                contactArray.add(userData);

                return null;

            }while (contactInformation.moveToNext());


        }
        protected void onPostExecute(Void avoid){
            super.onPreExecute();
            adapter=new CustomAdapter(MainActivity.this,contactArray);
            list.setAdapter(adapter);
            list.setFastScrollEnabled(true);
        }
    }
    protected void onStop(){
        super.onStop();
        contactInformation.close();
    }
}

