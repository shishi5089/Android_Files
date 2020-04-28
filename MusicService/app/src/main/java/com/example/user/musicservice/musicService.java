package com.example.user.musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by user on 3/24/2017.
 */
public class musicService extends Service {
    MediaPlayer mPlayer;

    public musicService(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
      throw new UnsupportedOperationException("service not running");
    }
    public void onCreate(){
        super.onCreate();
        mPlayer=MediaPlayer.create(this,R.raw.unsteady);

    }
    public int onStartCommand(Intent intent,int flags,int startId){
        mPlayer.start();
        return super.onStartCommand(intent,flags,startId);

    }
    public void onDestroy(){
        mPlayer.stop();
        super.onDestroy();
    }

}
