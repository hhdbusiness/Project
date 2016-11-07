package com.example.veigar.testlifecycle;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Veigar on 16/10/13.
 */

public class DispatchDialog extends Dialog {
    public DispatchDialog(Context context) {
        super(context);
    }

    public DispatchDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TouchTestActivity","DispatchDialog dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTestActivity","DispatchDialog onTouchEvent");
        return false;
    }
}
