/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2video;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;


public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
            WindowManager w = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            Display d = w.getDefaultDisplay();
            int rotation = d.getRotation();
			int SCREEN_WIDTH;
			int SCREEN_HEIGHT;
            // 根据屏幕方向获取手机屏幕的真实宽度
            if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) {
                SCREEN_WIDTH = d.getWidth();
            } else {
                SCREEN_WIDTH = d.getHeight();
            }
            if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) {
                SCREEN_HEIGHT = d.getHeight();
            } else {
                SCREEN_HEIGHT = d.getWidth();
            }

			Log.d("TTT", "screen width " + SCREEN_WIDTH + " height " + SCREEN_HEIGHT);


        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2VideoFragment.newInstance())
                    .commit();
        }
    }

}
