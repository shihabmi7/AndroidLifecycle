package com.sebpo.androidlifecycle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private String tag = "LogInActivity";
    Button button, buttonShow;

    SharedPreferences sharedPreferences;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(tag, "onCreate");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*sharedPreferences = getSharedPreferences("Food",
                MODE_PRIVATE);*/

        button = findViewById(R.id.buttonClick);
        buttonShow = findViewById(R.id.buttonShow);
        editText = findViewById(R.id.edtLogIn);
        textView = findViewById(R.id.textView_title);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppSharedPreference.getDefaultPreferences().putString("pin", editText.getText().toString());
                showToast(editText.getText().toString());

            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String pin = sharedPreferences.getString("pin", "content not found.");
                String pin = AppSharedPreference.getDefaultPreferences().getString("pin");
                showToast(pin);

            }
        });
    }

    private void showToast(String value) {


        Toast.makeText(getApplicationContext(),
                value, Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
