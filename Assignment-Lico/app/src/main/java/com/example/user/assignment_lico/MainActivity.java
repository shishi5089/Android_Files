package com.example.user.assignment_lico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView countries;
    ListView list;
    String[]country={"Kenya","South Africa","U.S.A","Canada","Dubai","France","Egypt"};
    String selectedCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries=(TextView)findViewById(R.id.countries);
        list=(ListView)findViewById(R.id.list);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,country);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "You selected " + selectedCountry, Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(list);
        list.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("select an action");
                menu.add(0,v.getId(),0,"delete");
                menu.add(0,v.getId(),0,"add to screen");
                menu.add(0,v.getId(),0,"successful test");
            }
        });

    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="delete"){
            Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_LONG).show();
            list.setList("Deleted");
        }
        if(item.getTitle()=="add to screen"){
            Toast.makeText(MainActivity.this,"add to screen",Toast.LENGTH_LONG).show();
            list.setText("Add to screen");
        }
        if(item.getTitle()=="successful test"){
            Toast.makeText(MainActivity.this,"successful test",Toast.LENGTH_LONG).show();
            list.setText("Successful test");
        }
        return true;
    }
}
