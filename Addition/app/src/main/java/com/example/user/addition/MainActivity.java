package com.example.user.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView addition;
    EditText first,second,answer;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addition=(TextView)findViewById(R.id.addition);
        first=(EditText)findViewById(R.id.first);
        second=(EditText)findViewById(R.id.second);
        add=(Button)findViewById(R.id.add);
        answer=(EditText)findViewById(R.id.answer);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer firstNumber,secondNumber,ans;

                firstNumber=Integer.parseInt(first.getText().toString());
                secondNumber=Integer.parseInt(second.getText().toString());
                ans=firstNumber+secondNumber;
                //String theAns=ans.toString();

                Toast.makeText(MainActivity.this,""+ans,Toast.LENGTH_LONG).show();
                answer.setText(ans.toString());
            }
        });

    }
}
