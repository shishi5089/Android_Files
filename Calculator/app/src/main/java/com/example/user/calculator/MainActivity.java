package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    TextView num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    TextView addition,subtraction,multiplication,division,equals;
    TextView firstnumber,secondnumber,symbol,dot;
    Button clear,delete;

    public static String first="0";
    public static String second="0";
    public  String numberListener="";
    public String numberListener2=" ";
    public Integer public_key=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0=(TextView)findViewById(R.id.zero);
        num1=(TextView)findViewById(R.id.one);
        num2=(TextView)findViewById(R.id.two);
        num3=(TextView)findViewById(R.id.three);
        num4=(TextView)findViewById(R.id.four);
        num5=(TextView)findViewById(R.id.five);
        num6=(TextView)findViewById(R.id.six);
        num7=(TextView)findViewById(R.id.seven);
        num8=(TextView)findViewById(R.id.eight);
        num9=(TextView)findViewById(R.id.nine);
        addition=(TextView)findViewById(R.id.addition);
        subtraction=(TextView)findViewById(R.id.subtraction);
        multiplication=(TextView)findViewById(R.id.multiplication);
        division=(TextView)findViewById(R.id.division);
        equals=(TextView)findViewById(R.id.equalsign);
        firstnumber=(TextView)findViewById(R.id.firstnumber);
        secondnumber=(TextView)findViewById(R.id.secondnumber);
        symbol=(TextView)findViewById(R.id.symbol1);
        dot=(TextView)findViewById(R.id.dot);
        clear=(Button)findViewById(R.id.clear);
        delete=(Button)findViewById(R.id.delete1);

        firstnumber.setText(" ");
        secondnumber.setText(" ");
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNumber();
            }
        });


        changeNumber();
        changeSign();
        reset();

    }
    public void deleteNumber(){
      try{
          if(public_key==0 && firstnumber.getText() !=""){
              numberListener=numberListener.substring(0,numberListener.length()-1);
              firstnumber.setText(numberListener);
          }
          if (public_key==0 && secondnumber.getText() !=""){
              numberListener2=numberListener2.substring(0,numberListener2.length()-1);
              secondnumber.setText(numberListener2);
              if(firstnumber.getText()!= ""){
                  numberListener=numberListener.substring(0,numberListener.length()-1);
                  firstnumber.setText(numberListener);
                  public_key=public_key*0;
              }
        }catch(StringIndexOutOfBoundsException error){

          }
    }



    public void reset(){
        firstnumber.setText("");
        secondnumber.setText("");
        symbol.setText("");
        public_key=public_key*0;
        numberListener=("");
        numberListener2=("");
    }



    public void changeNumber(){
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "0";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"0";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "1";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"1";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "2";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"2";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "3";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"3";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "4";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"4";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (public_key == 0) {
                    numberListener = numberListener + "5";
                    firstnumber.setText(numberListener);
                } else {
                    numberListener2 = numberListener2 + "5";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (public_key == 0) {
                    numberListener = numberListener + "6";
                    firstnumber.setText(numberListener);
                } else {
                    numberListener2 = numberListener2 + "6";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (public_key == 0) {
                    numberListener = numberListener + "7";
                    firstnumber.setText(numberListener);
                } else {
                    numberListener2 = numberListener2 + "7";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "8";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"8";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + "9";
                    firstnumber.setText(numberListener);
                }
                else {
                    numberListener2=numberListener2 +"9";
                    secondnumber.setText(numberListener2);
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(public_key==0) {
                    numberListener = numberListener + ".";
                    firstnumber.setText(numberListener2);
                }
                else {
                    numberListener2=numberListener2 +".";
                    secondnumber.setText(numberListener2);
                }
            }
        });


    }
    public void changeSign(){
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol.setText("+");
                public_key=public_key+1;
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol.setText("-");
                public_key=public_key+1;

            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol.setText("X");
                public_key=public_key+1;

            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol.setText("/");
                public_key=public_key+1;

            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol.setText("=");
                public_key=public_key+1;
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol.setText(".");
                public_key=public_key+1;
            }
        });
    }
    public void result(){
        Double num1,num2;

        Double answer;
        num1=Double.parseDouble(numberListener);
        num2=Double.parseDouble(numberListener2);

        try{
            if(firstnumber.getText()=="" ||secondnumber.getText()=="");{
          reset();
            }
            if(symbol.getText()=="+"){
                answer=num1+num2;
                Toast.makeText(getApplicationContext(),""+answer.toString(),Toast.LENGTH_SHORT).show();
            }
            if(symbol.getText()=="-"){
                answer=num1-num2;
                firstnumber.setText(num1.toString()+symbol.toString()+num2.toString());
                symbol.setText("=");
                secondnumber.setText(answer.toString());

            }
            if(symbol.getText()=="X"){
                answer=num1*num2;
                firstnumber.setText(num1.toString()+symbol.toString()+num2.toString());
                symbol.setText("=");
                secondnumber.setText(answer.toString());
            }
            if(symbol.getText()=="/"){
                if(firstnumber.getText()=="0"||secondnumber.getText()=="0"){
                    reset();
                }
                else{
                answer=num1/num2;
                firstnumber.setText(num1.toString()+symbol.toString()+num2.toString());
                symbol.setText("=");
                secondnumber.setText(answer.toString());
                Toast.makeText(MainActivity.this," "+answer,Toast.LENGTH_SHORT).show();
                }
            }
        }catch(Exception e){
            Log.e("Error ","not functioning");
        }
    }

}
