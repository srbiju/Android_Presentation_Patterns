package com.bpdev.vinner.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bpdev.vinner.R;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {
    private Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void sendCustomNotification(View view){

    }
}
