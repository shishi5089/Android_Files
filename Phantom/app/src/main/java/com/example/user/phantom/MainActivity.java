package com.example.user.phantom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView phantom;
    EditText name;
    EditText card;
    RadioButton male;
    RadioGroup group;
    String selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phantom = (TextView) findViewById(R.id.phantom);
        name = (EditText) findViewById(R.id.Name);
        card = (EditText) findViewById(R.id.card);

        group = (RadioGroup) findViewById(R.id.groupGender);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.equals(group)) {
                    if (male.isChecked()) {
                        selectedGender = male.getText().toString();
                        Toast.makeText(MainActivity.this, "You selected the :" + selectedGender, Toast.LENGTH_LONG).show();


                    }
                }
            }
        });
    }
}



