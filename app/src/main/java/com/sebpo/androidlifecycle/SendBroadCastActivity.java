package com.sebpo.androidlifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SendBroadCastActivity extends AppCompatActivity {

    private static final String CUSTOM_ACTION = "com.sebpo.custom";
    LocalBroadcastManager localBroadcastManager;
    private String tag = "SendBroadCastActivity";
    private TextView textViewHellowWorld;
    private Button button_clickMe;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewHellowWorld = findViewById(R.id.textViewHellowWorld);
        button_clickMe = findViewById(R.id.button_clickMe);

        localBroadcastManager =
                LocalBroadcastManager.getInstance(this);

        button_clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent anIntent = new Intent(CUSTOM_ACTION);
                // You can also include some extra data.
                count++;
                anIntent.putExtra("message", "This is my message! message no: ");
                //LocalBroadcastManager.getInstance(this).sendBroadcast(anIntent);
                localBroadcastManager.sendBroadcast(anIntent);
            }
        });
    }

    private BroadcastReceiver listener = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String data = intent.getStringExtra("message");
            textViewHellowWorld.setText(data + count);
            //Log.d(tag, data);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        /*LocalBroadcastManager.getInstance(this).
                registerReceiver(listener,
                        new IntentFilter(CUSTOM_ACTION));*/

        localBroadcastManager.
                registerReceiver(listener,
                        new IntentFilter(CUSTOM_ACTION));
    }
}
