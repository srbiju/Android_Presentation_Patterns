package com.bpdev.vinner.view.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.bpdev.vinner.BuildConfig;
import com.bpdev.vinner.R;
import com.bpdev.vinner.view.broadcastreceiver.CustomReceiver;

import androidx.appcompat.app.AppCompatActivity;

public class BroadcastTestActivity extends AppCompatActivity {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private CustomReceiver mCustomReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);

        IntentFilter intFilter = new IntentFilter();
        intFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(mCustomReceiver, intFilter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mCustomReceiver);
        super.onDestroy();
    }

    public void sendCustomBroadcast(){
        Intent sendCustIntent = new Intent(ACTION_CUSTOM_BROADCAST);
    }

}
