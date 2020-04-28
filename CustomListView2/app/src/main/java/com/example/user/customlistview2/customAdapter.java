package com.example.user.customlistview2;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 3/3/2017.
 */
public class customAdapter extends BaseAdapter{
    //creating global variables for the constructor;
    int[]imagesArray;
    String[]moviesArray,categoryArray;
    public static LayoutInflater inflater=null;
    Context context;
    //create a constructor matching MainActivity Class

    public customAdapter(MainActivity mainActivity,int[]images,String[]movies,String[]category){
        //connecting the global variables with the constructor parameters
        imagesArray=images;
        moviesArray=movies;
        categoryArray=category;
        context=mainActivity;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagesArray.length;
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
        Holder holder =new Holder();

        //creating the view method
        convertView=inflater.inflate(R.layout.custom_layout,null);

        //binding the view method with data
        holder.name1=(TextView)convertView.findViewById(R.id.name1);
        holder.name2=(TextView)convertView.findViewById(R.id.name2);
        holder.image1=(ImageView)convertView.findViewById(R.id.image1);

        holder.image1.setImageResource(imagesArray[position]);
        holder.name1.setText(moviesArray[position]);
        holder.name2.setText(categoryArray[position]);

        return convertView;
    }
}
