package com.example.user.alarmsystem;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by user on 3/28/2017.
 */
public class alarmService extends Service {

    MediaPlayer mediaPlayer;
    int startId;
    boolean isRunning;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent,int flags,int startId){
        String stateOfAlarm=intent.getExtras().getString("alarmState");


        assert stateOfAlarm !=null;

        switch(stateOfAlarm){
            case "alarm on":
                startId=1;
                break;
            case "alarm off":
                startId=0;
                break;
        }

        if(!this.isRunning && startId==1){
          mediaPlayer=MediaPlayer.create(this,R.raw.gemini);
            mediaPlayer.start();

            this.isRunning=true;
           this.startId=0;

            NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            Intent alarm_intent=new Intent(this.getApplicationContext(),MainActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(this,0,alarm_intent,0);

            Notification notificationPopUp=new Notification.Builder(this)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.pic1)
                    .setContentTitle("Time is up")
                    .setContentIntent(pendingIntent)
                    .setContentText("Click to turn off")
                    .build();

            notificationManager.notify(0,notificationPopUp);


        }
        if(this.isRunning && startId==1){
            this.isRunning=true;
            this.startId=1;

        }
        if(this.isRunning && startId==0){
            mediaPlayer.stop();
            mediaPlayer.reset();
            this.isRunning=false;
            this.startId=0;

        }
        if(!this.isRunning && startId==1){
            this.isRunning=true;
            this.startId=0;
        }


        return START_NOT_STICKY;

    }

    public void onDestroy(){
        super.onDestroy();
        this.isRunning=false;
    }
}
