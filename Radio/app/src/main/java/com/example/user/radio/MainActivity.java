package com.example.user.radio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView radio;
    RadioGroup group;
    RadioButton male,female;
    public String selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio=(TextView)findViewById(R.id.text1);
        group=(RadioGroup)findViewById(R.id.groupGender);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                                             @Override
                                             public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                 if(group.equals(group))
                                                 {
                                                     if(male.isChecked())
                                                     {
                                                        selectedGender=male.getText().toString();
                                                         Toast.makeText(MainActivity.this, "You selected the :" +selectedGender, Toast.LENGTH_LONG).show();
                                                     }
                                                     if(female.isChecked())
                                                     {
                                                         selectedGender=female.getText().toString();
                                                         Toast.makeText(MainActivity.this, "You selected the :" +selectedGender, Toast.LENGTH_LONG).show();
                                                     }
                                                 }


                                             }
                                         }
        );



    }
}
