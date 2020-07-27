package com.program.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private Handler handler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        handler = new Handler();
        handler.postDelayed(runnable,5000);

        Toast.makeText(this,"Servis Çalışmaya Başladı.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Servis Durdu.",Toast.LENGTH_SHORT).show();
        handler.removeCallbacks(runnable);
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Toast.makeText(MyService.this,"Servis Çalışmaya Devam Ediyor.",Toast.LENGTH_SHORT).show();
            MyService.this.handler.postDelayed(runnable,5000);
        }
    };

}
