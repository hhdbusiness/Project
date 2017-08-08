package com.example.veigar.testlifecycle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veigar.protector.SmallRankDialog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Veigar on 16/10/27.
 */

public class FirstActivity extends Activity {

    private ImageButton btn_start;
    private EditText et_input;
    private SoundPool soundPool;
    private Button btn_reduce;
    private Button btn_add;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn_start = (ImageButton) findViewById(R.id.btn_start);
        et_input = (EditText) findViewById(R.id.et_input);
        btn_reduce = (Button) findViewById(R.id.btn_reduce);
        btn_add = (Button) findViewById(R.id.btn_add);
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        setEditText();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittextStr = et_input.getText().toString().trim();
                int selection = et_input.getSelectionStart();
                StringBuilder  stringBuilder = new StringBuilder (edittextStr);
                stringBuilder.insert(selection,"8");
                et_input.setText(stringBuilder);
                et_input.setSelection(selection + 1);
            }
        });

        btn_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittextStr = et_input.getText().toString().trim();
                int selection = et_input.getSelectionStart();
                if(edittextStr.length() > 0 && selection > 0) {
                    StringBuilder stringBuilder = new StringBuilder(edittextStr);
                    stringBuilder.delete(selection - 1, selection);
                    et_input.setText(stringBuilder);
                    et_input.setSelection(selection - 1);
                }
            }
        });


            /*int currentVersion = android.os.Build.VERSION.SDK_INT;
            String methodName = null;
            if(currentVersion >= 16){啊
                // 4.2
                methodName = "setShowSoftInputOnFocus";
            }
            else if(currentVersion >= 14){
                // 4.0
                methodName = "setSoftInputShownOnFocus";
            }

            if(methodName == null){
                et_input.setInputType(InputType.TYPE_NULL);
            }
            else{
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                try {
                    setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                    setShowSoftInputOnFocus.setAccessible(true);
                    setShowSoftInputOnFocus.invoke(et_input, false);
                } catch (NoSuchMethodException e) {
                    et_input.setInputType(InputType.TYPE_NULL);
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }*/
//        et_input.setInputType(InputType.TYPE_NULL);
//        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(et_input.getWindowToken(), InputMethodManager.RESULT_HIDDEN);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.gift_anim_two);
        btn_start.startAnimation(animation);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                /*soundPool= new SoundPool(1, AudioManager.STREAM_MUSIC,0);
                soundPool.load(FirstActivity.this,R.raw.video_detail_sponsor_view_bg,1);
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                        soundPool.play(1,1, 1, 0, 0, 1);
                    }
                });*/


            }
        });

    }

    private void setEditText() {
//        et_input.setShowSoftInputOnFocus(false);

        /*et_input.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP) {
                    inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return true;
            }
        });*/

        /*et_input.setLongClickable(false);
        et_input.setTextIsSelectable(false);
        et_input.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }
        });*/
    }

    public void showDialog(){
        PersonRankData personRankData = new PersonRankData();
        personRankData.setRank(80);
        SmallRankDialog smallRankDialog = SmallRankDialog.createDialog(FirstActivity.this,personRankData);
        smallRankDialog.show();
        /*View becomeSponsor = View.inflate(this, R.layout.dialog_content, null);
        Dialog dialog = new Dialog(this, R.style.dialog_no_dim);
        dialog.setContentView(becomeSponsor);
        Window mWindow = dialog.getWindow();
        mWindow.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        WindowManager.LayoutParams layoutParams = mWindow.getAttributes();
        layoutParams.y = 200;
        dialog.show();*/
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
