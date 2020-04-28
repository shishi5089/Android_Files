package com.example.user.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView country;
    ListView list1;
    String[]countries={"Kenya","Tanzania","Uganda","Zambia","Zimbabwe","Burundi","Congo","Egypt","Ethiopia","Cameroon","South Africa","Rwanda"};
    String selectedChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country=(TextView)findViewById(R.id.country);
        list1=(ListView)findViewById(R.id.list1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,countries);

                list1.setAdapter(adapter);
                list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectedChoice=parent.getItemAtPosition(position).toString();
                        Toast.makeText(MainActivity.this,"You selected "+selectedChoice,Toast.LENGTH_LONG).show();

                    }
                });
    }
}
