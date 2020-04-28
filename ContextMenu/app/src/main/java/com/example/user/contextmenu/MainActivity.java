package com.example.user.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hold=(TextView)findViewById(R.id.hold);

        registerForContextMenu(hold);

        hold.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.setHeaderTitle("select an action");
                contextMenu.add(0,v.getId(),0,"delete");
                contextMenu.add(0,v.getId(),0,"add to screen");
                contextMenu.add(0,v.getId(),0,"successful test");


            }
        });


    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="delete"){
            Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_LONG).show();
            hold.setText("Deleted");
        }
        if(item.getTitle()=="add to screen"){
            Toast.makeText(MainActivity.this,"add to screen",Toast.LENGTH_LONG).show();
            hold.setText("Add to screen");
        }
        if(item.getTitle()=="successful test"){
            Toast.makeText(MainActivity.this,"successful test",Toast.LENGTH_LONG).show();
            hold.setText("Successful test");
        }
        return true;
    }
}
