package com.example.user.contactretriever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 3/7/2017.
 */
public class CustomAdapter extends BaseAdapter{

    List<SelectUser>listData;
    ArrayList<SelectUser>arrayList;
    Context context;

    public  static LayoutInflater inflater=null;

    public CustomAdapter(Context con,List<SelectUser>list){

        context=con;
        listData=list;
        //constructing an array from the list
        this.arrayList=new ArrayList<SelectUser>();
        arrayList.addAll(listData);
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listData.size();
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

        convertView=inflater.inflate(R.layout.contact,null);

        ViewHolder holder=new ViewHolder();

        holder.nameText=(TextView)convertView.findViewById(R.id.contacts);
        holder.phoneText=(TextView)convertView.findViewById(R.id.phonenumbers);
        holder.imageView=(ImageView)convertView.findViewById(R.id.images);

        SelectUser userData=new SelectUser();
        holder.nameText.setText(userData.getUserName());
        holder.phoneText.setText(userData.getPhoneNumber());
        try {
            if(userData.getBitmap()!=null){
                holder.imageView.setImageBitmap(userData.getBitmap());
            }
            else{
                holder.imageView.setImageResource(R.drawable.shish);
            }

        } catch(OutOfMemoryError error){
            holder.imageView.setImageDrawable(this.context.getDrawable(R.drawable.shish));
            error.printStackTrace();
        }
        convertView.setTag(userData);
        return null;
    }

    class ViewHolder{
        TextView nameText,phoneText;
        ImageView imageView;
    }
}
