package com.sebpo.androidlifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private String tag = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()))
            // if (intent.getS)
            Toast.makeText(context, "Boot Completeded..",
                    Toast.LENGTH_LONG).show();

        Log.d(tag, "onReceive called");

    }
}
