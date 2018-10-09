package com.example.admin.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    ConnectionRecevier receiver;
    Button b;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   //     ButterKnife.inject(this);

        receiver = new ConnectionRecevier();
        intentFilter = new IntentFilter("com.example.admin.broadcastrecevier.SOME_ACTION");

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

  @OnClick(R.id.button)
    void someMethod() {

        Intent intent = new Intent("com.example.admin.broadcastrecevier.SOME_ACTION");
        sendBroadcast(intent);
    }
}
