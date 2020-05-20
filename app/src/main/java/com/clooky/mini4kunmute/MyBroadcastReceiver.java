package com.clooky.mini4kunmute;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.media.AudioManager;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver
{
    private static final String TAG = "MyBroadcastReceiver";
    private AudioManager audioManager;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);

        if(intent.getAction() == Intent.ACTION_BOOT_COMPLETED) {
            Log.d(TAG, "registering other intents");

            //register this event in the application context so that we can unmute every time we wake up
            IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
            context.getApplicationContext().registerReceiver(this, filter);
        }

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, 0);
    }
}
