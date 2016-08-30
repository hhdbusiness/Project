package com.example.veigar.testlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Veigar on 16/6/27.
 */
public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Second", "onComcomcom");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Second", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Second", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Second", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Second", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Second", "onDestroy");
    }
}
