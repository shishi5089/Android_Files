package com.example.user.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by user on 3/2/2017.
 */
public class customAdapter extends BaseAdapter {

    String[]names,phones,status;
    Context context;

    public static LayoutInflater inflater=null;

    public customAdapter(MainActivity mainActivity,String[]stringNames,String[]stringPhones,String[]stringStatus){
        context=mainActivity;
        names=stringNames;
        phones=stringPhones;
        status=stringStatus;

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        convertView= inflater.inflate(R.layout.call_log,null);
        holder.nameHolder=(TextView)convertView.findViewById(R.id.names);
        holder.phoneHolder=(TextView)convertView.findViewById(R.id.phonenumbers);
        holder.statusHolder=(TextView)convertView.findViewById(R.id.status);

        holder.nameHolder.setText(names[position]);
        holder.phoneHolder.setText(phones[position]);
        holder.statusHolder.setText(status[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked "+names[position], Toast.LENGTH_SHORT).show();
            }
        });




        return convertView;
    }
    public class Holder{
        TextView nameHolder,phoneHolder,statusHolder;
    }
}
