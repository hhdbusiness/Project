package com.example.veigar.testlifecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Veigar on 16/10/13.
 */

public class DispatchView extends LinearLayout {
    public DispatchView(Context context) {
        super(context);
    }

    public DispatchView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTestActivity","DispatchView onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("TouchTestActivity","DispatchView dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }
}
