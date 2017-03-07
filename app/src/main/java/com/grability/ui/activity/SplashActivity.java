package com.grability.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.grability.ui.activity.theme.ThemeActivity;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, ThemeActivity.class));
            }
        });
    }
}
