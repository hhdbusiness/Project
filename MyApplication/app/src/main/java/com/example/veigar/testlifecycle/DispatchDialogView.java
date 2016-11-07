package com.example.veigar.testlifecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Veigar on 16/10/13.
 */

public class DispatchDialogView extends View{
    public DispatchDialogView(Context context) {
        super(context);
    }

    public DispatchDialogView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTestActivity","DispatchDialogView onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("TouchTestActivity","DispatchDialogView dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }
}
