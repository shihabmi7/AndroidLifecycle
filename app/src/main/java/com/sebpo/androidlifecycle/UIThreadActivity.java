package com.sebpo.androidlifecycle;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UIThreadActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonStart, buttonStop;
    private boolean mLoopRunning = true;
    private String tag = "UIThreadActivity";
    TextView textview_thread_number;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uithread);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        textview_thread_number = findViewById(R.id.textview_thread_number);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

        Log.d(tag, "name: " + Thread.currentThread().getName() +
                " id:" + Thread.currentThread().getId());

        createHandler();
    }

    Thread thread;

    @Override
    public void onClick(View v) {

        if (v == buttonStart) {
            mLoopRunning = true;

            thread = new Thread(new Runnable() {
                @Override
                public void run() {


                    while (mLoopRunning) {

                        try {

                            Thread.sleep(1000);

                            count++;
                            Log.d(tag, "name: " + Thread.currentThread().getName() +
                                    " id:" + Thread.currentThread().getId());

                        } catch (Exception e) {

                            e.printStackTrace();
                        }

                        giveTaskToHandler();
                    }


                }
            });

            thread.start();


        } else if (v == buttonStop) {

            mLoopRunning = false;

        }
    }


    Handler handler;

    void createHandler() {

        handler = new Handler(getMainLooper());
    }

    void giveTaskToHandler() {

        handler.post(new Runnable() {
            @Override
            public void run() {

                textview_thread_number.setText("" + count);
            }
        });
    }

    void widgetToLooper(){

        textview_thread_number.post(new Runnable() {
            @Override
            public void run() {
                textview_thread_number.setText("" + count);
            }
        });
    }

}
