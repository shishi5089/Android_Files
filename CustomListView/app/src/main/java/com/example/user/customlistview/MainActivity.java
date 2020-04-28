package com.example.user.customlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static String[]stringNames={"wanjiru","joe","roy","sarah","eunice","radhia","jeff","allan","nangila","nelson"};
    public static String[]stringPhones={"0700000000","0711111111","0722222222","0733333333","0744444444","0755555555","0766666666","0777777777","0788888888","079999999"};
    public static String[]stringStatus={"received","outgoing","missed call","received","rejected","outgoing","rejected","received","missed call","received"};

    Context context;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        list=(ListView)findViewById(R.id.list);

        list.setAdapter(new customAdapter(this,stringNames,stringPhones,stringStatus));

    }
}
