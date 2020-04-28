package com.example.user.alarmsystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by user on 3/28/2017.
 */
public class alarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String alarm_state=intent.getExtras().getString("alarmState");

        Intent serviceIntent=new Intent(context,alarmService.class);
        serviceIntent.putExtra("alarmState",alarm_state);
        context.startService(serviceIntent);
    }
}
