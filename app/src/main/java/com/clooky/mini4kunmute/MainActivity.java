/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.clooky.mini4kunmute;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;



/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends Activity {

    private AudioManager audioManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, 0);

        setContentView(R.layout.first);
    }


    public void onVolUp(View v) {
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, 0);
    }

    public void onVolDown(View v) {
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, 0);
    }

    public void onMute(View v) {
        audioManager.adjustVolume(AudioManager.ADJUST_MUTE, 0);
    }

    public void onUnmute(View v) { audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, 0); }

    public void onQuit(View v) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}

