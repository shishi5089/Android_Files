package com.example.user.remotedb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button save;
    EditText courseName;

    public static String courseString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        save=(Button)findViewById(R.id.saveCourse);
        courseName=(EditText)findViewById(R.id.newCourse);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseString=courseName.getText().toString();

                new AddCourseTask().execute();
            }
        });
    }

    public class AddCourseTask extends AsyncTask<String,String,String>{
        int successState=0;
        String serverMessage;

        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
           String response_success_Tag="success";
            String response_message_Tag="message";

            JSONParser jsonParser=new JSONParser();
            List<NameValuePair>jsonDataParameters=new ArrayList<NameValuePair>();
            jsonDataParameters.add(new BasicNameValuePair("courses",courseString));

           JSONObject jsonObjectResponse= jsonParser.makingHttpRequest("http://192.168.173.1:1234/localhost/www.zalego.com/school/addCourse.php", "GET", jsonDataParameters);

            try{
                int success=jsonObjectResponse.getInt(response_success_Tag);
                serverMessage=jsonObjectResponse.getString(response_message_Tag);

                if(success==1){
                    successState=1;
                }

            }catch (Exception e){
                e.printStackTrace();
            }


            return null;
        }

        protected void onPostExecute(String s){
            super.onPostExecute(s);

            if(successState==1){
                Toast.makeText(getApplicationContext(),"success "+serverMessage,Toast.LENGTH_LONG).show();
                courseName.setText("");
            }

            else{
                Toast.makeText(getApplicationContext(),"fail "+serverMessage, Toast.LENGTH_LONG).show();
            }
        }


    }
}
