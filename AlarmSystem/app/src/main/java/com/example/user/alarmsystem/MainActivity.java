package com.example.user.alarmsystem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    TextView theTimeSet;
    Button startAlm,stopAlm;
    TimePicker timePicker;
    PendingIntent pendingintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        theTimeSet=(TextView)findViewById(R.id.timeSet);
        startAlm=(Button)findViewById(R.id.startAlarm);
        stopAlm=(Button)findViewById(R.id.stopAlarm);
        timePicker=(TimePicker)findViewById(R.id.pickTime);

        final Calendar calendar=Calendar.getInstance();
        final Intent intent=new Intent(MainActivity.this,alarmReceiver.class);

        startAlm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());

                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();

                String hourString=String.valueOf(hour);
                String minuteString=String.valueOf(minute);

                if(minute<10){
                    minuteString ="0"+minuteString;
                }
                if(hour>12){
                    hourString=String.valueOf(hour-12);
                    setAlarmTime("Time set to "+hourString+":"+minuteString+" PM");
                }
                else{
                    setAlarmTime("Time set to "+hourString+":"+minuteString+" AM");
                }

                intent.putExtra("alarmState","alarm on");
                pendingintent=PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingintent);
            }
        });

        stopAlm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("alarmState","alarm off");
                setAlarmTime("alarm off");
                sendBroadcast(intent);
            }
        });


    }

    public void setAlarmTime(String timeSet){
        theTimeSet.setText(timeSet);
    }
}
