package com.example.user.mysql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 3/16/2017.
 */
public class CustomAdapter extends BaseAdapter {
    String[]uname,uage,ugender,uphonenumber,uemail;
    Context context;
    public static LayoutInflater inflater=null;

    public CustomAdapter(RetrieveData retrieveData,String[]name,String[]age,String[]email,String[]gender,String[]phonenumber){
        uname=name;
        uage=age;
        uemail=email;
        ugender=gender;
        uphonenumber=phonenumber;

        context=retrieveData;

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return uname.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=inflater.inflate(R.layout.custom_row,null);
        TextView text_name=(TextView)convertView.findViewById(R.id.text1);
        TextView text_age=(TextView)convertView.findViewById(R.id.text2);
        TextView text_gender=(TextView)convertView.findViewById(R.id.text3);
        TextView text_phonenumber=(TextView)convertView.findViewById(R.id.text5);
        TextView text_email=(TextView)convertView.findViewById(R.id.text4);

        text_name.setText(uname[position]);
        text_age.setText(uage[position]);
        text_email.setText(uemail[position]);
        text_gender.setText(ugender[position]);
        text_phonenumber.setText(uphonenumber[position]);

        return convertView;
    }
}
