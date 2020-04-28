package com.example.user.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox check1,check2,check3;
    String selectedCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check1=(CheckBox)findViewById(R.id.check1);
        check2=(CheckBox)findViewById(R.id.check2);
        check3=(CheckBox)findViewById(R.id.check3);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String selectedCheckBox;
                selectedCheckBox=check1.getText().toString();
                Toast.makeText(MainActivity.this,"You selected "+selectedCheckBox,Toast.LENGTH_LONG).show();
            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCheckBox;
                selectedCheckBox=check2.getText().toString();
                Toast.makeText(MainActivity.this,"You selected "+selectedCheckBox,Toast.LENGTH_LONG).show();

            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCheckBox;
                selectedCheckBox=check3.getText().toString();
                Toast.makeText(MainActivity.this,"You selected "+selectedCheckBox,Toast.LENGTH_LONG).show();

            }
        });
    }
}
