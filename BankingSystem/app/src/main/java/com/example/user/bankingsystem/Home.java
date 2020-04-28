package com.example.user.bankingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView page;
    EditText email,id,accname,accnumber,card,phone;
    Button register;
    RadioButton male,female;
    RadioGroup group;
    String selectedGender;
    String selectedCountry;
    String selectedBank;
Spinner spinner1,spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        page=(TextView)findViewById(R.id.page);
        email=(EditText)findViewById(R.id.email);
        id=(EditText)findViewById(R.id.id);
        accname=(EditText)findViewById(R.id.accname);
        accnumber=(EditText)findViewById(R.id.accnumber);
        card=(EditText)findViewById(R.id.card);
        phone=(EditText)findViewById(R.id.phone);
        group=(RadioGroup)findViewById(R.id.groupGender);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);
        register=(Button)findViewById(R.id.register);

        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(Home.this,R.array.Countries,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Home.this, "You have selected " + selectedCountry, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adapter1=ArrayAdapter.createFromResource(Home.this,R.array.Banks,R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Home.this, "You have selected " + selectedBank, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDummy = new Intent(Home.this, DummyHomePage.class);
                Home.this.startActivity(goDummy);
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                                             @Override
                                             public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                 if(group.equals(group))
                                                 {
                                                     if(male.isChecked())
                                                     {
                                                         selectedGender=male.getText().toString();
                                                         Toast.makeText(Home.this, "You selected the :" + selectedGender, Toast.LENGTH_LONG).show();
                                                     }
                                                     if(female.isChecked())
                                                     {
                                                         selectedGender=female.getText().toString();
                                                         Toast.makeText(Home.this, "You selected the :" +selectedGender, Toast.LENGTH_LONG).show();
                                                     }
                                                 }


                                             }
                                         }
        );


    }
}
