package com.example.veigar.testlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Veigar on 16/10/27.
 */

public class FirstActivity extends Activity {

    private ImageButton btn_start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn_start = (ImageButton)findViewById(R.id.btn_start);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.gift_anim_two);
        btn_start.startAnimation(animation);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,GiftsDialogActivity.class);
                startActivity(intent);
            }
        });
    }
}
