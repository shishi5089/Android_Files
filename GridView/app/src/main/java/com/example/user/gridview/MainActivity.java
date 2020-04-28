package com.example.user.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView game;
    GridView grid;
    String[]games={"Football","Volleyball","Handball","Basketball","Chess","Swimming","Rugby","Tennis","Short put","Athletics","Soccer","Skating"};
    String selectedGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid=(GridView)findViewById(R.id.grid1);
        game=(TextView)findViewById(R.id.games);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,games);

        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedGrid=parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,"You selected "+selectedGrid,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
