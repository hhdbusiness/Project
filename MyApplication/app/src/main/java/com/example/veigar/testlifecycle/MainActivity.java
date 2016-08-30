package com.example.veigar.testlifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv_goto;
    private TextView tv_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_goto = (TextView)findViewById(R.id.tv_goto);
        tv_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        tv_dialog = (TextView)findViewById(R.id.tv_dialog);
        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示");
                builder.show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Main", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Main", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Main", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Main", "onStop");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
