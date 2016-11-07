package com.example.veigar.testlifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Veigar on 16/10/13.
 */

public class TouchTestActivity extends Activity {

    private Button btn_click,btn_dialog;
    private View v_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_touch_test);
        btn_click = (Button)findViewById(R.id.btn_click);
        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        v_top = findViewById(R.id.v_top);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchTestActivity.this
                    ,"clickclickclick",Toast.LENGTH_SHORT).show();
            }
        });
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TouchTestActivity","TouchTestActivity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTestActivity","TouchTestActivity onTouchEvent");
        return super.onTouchEvent(event);
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确认退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                }
        });
        AlertDialog alertDialog =  builder.create();
        alertDialog.show();
    }

    private void showCustomDialog(){
        DispatchDialog  dispatchDialog = new DispatchDialog(this);
        dispatchDialog.setContentView(new DispatchDialogView(this));
        dispatchDialog.show();
    }
}
