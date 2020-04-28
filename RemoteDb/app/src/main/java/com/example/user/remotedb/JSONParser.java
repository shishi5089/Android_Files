package com.example.user.remotedb;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by user on 3/31/2017.
 */
public class JSONParser {

    static InputStream is=null;//communicationchannel
    static JSONObject jsonObject=null;//json Object
    static String Json="";//json data

    public JSONParser(){

    }

    //creating a json request method for the client
    public JSONObject makingHttpRequest(String url,String RESTfulMethod,List<NameValuePair>jsonObjectData){
        try{
            if(RESTfulMethod=="POST"){
                DefaultHttpClient httpClient=new DefaultHttpClient();


                //getting the url for execution
                HttpPost httpPost=new HttpPost(url);

                //appending the json objects to the url
                httpPost.setEntity(new UrlEncodedFormEntity(jsonObjectData));

                //executing the method and getting response from the server

                HttpResponse httpResponse=httpClient.execute(httpPost);

                HttpEntity httpEntity=httpResponse.getEntity();

                //getting the response from the server and storing it as
                //an input streamvalue
                is=httpEntity.getContent();


            }
            else if(RESTfulMethod=="GET"){
               DefaultHttpClient httpClient=new DefaultHttpClient();
                String jsonObjectString= URLEncodedUtils.format(jsonObjectData,"utf-8");

                //adding the json object to the url

                url+="?"+jsonObjectString;

                //executing the GET method and getting a response
                HttpGet httpGet=new HttpGet(url);

                HttpResponse httpResponse=httpClient.execute(httpGet);

                HttpEntity httpEntity=httpResponse.getEntity();

                is=httpEntity.getContent();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            BufferedReader reader= new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);

            StringBuffer sb=new StringBuffer();
            //converting the input stream information into string
            String line=null;
            while((line=reader.readLine())!=null){
                sb.append("+\n");
            }
            Json=sb.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}
