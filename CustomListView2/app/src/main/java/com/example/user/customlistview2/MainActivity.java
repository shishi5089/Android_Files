package com.example.user.customlistview2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    int[]images={R.drawable.img1,R.drawable.feet,R.drawable.jog,R.drawable.nail,R.drawable.pic1,R.drawable.clip};
    String[]movies={"zootopia","Fast and furious","Quantico","the conjuring","Game of thrones","two and a half men"};
    String[]category={"animation","conspiracy","horror","sitcom","comedy","action thriller"};
    ListView list;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        list=(ListView)findViewById(R.id.list);
        list.setAdapter(new customAdapter(this,images,movies,category));
    }
}
