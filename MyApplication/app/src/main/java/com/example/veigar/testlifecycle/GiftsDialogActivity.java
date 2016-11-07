package com.example.veigar.testlifecycle;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.example.veigar.gift.CustomGiftCountAdapter;

/**
 * Created by Veigar on 16/10/27.
 */

public class GiftsDialogActivity extends AppCompatActivity {

    private Button btn_show;
    private String TAG_GIFT_VERTICAL_DIALOG = "tag_gift_vertical_dialog";
    private GiftsVerticalDialog giftsVerticalDialog;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gifts_dialog);

        fragmentManager = getSupportFragmentManager();
        btn_show = (Button)findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giftsVerticalDialog = (GiftsVerticalDialog)fragmentManager.findFragmentByTag(TAG_GIFT_VERTICAL_DIALOG);
                if(giftsVerticalDialog == null){
                    giftsVerticalDialog = new GiftsVerticalDialog();
                }

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                giftsVerticalDialog.show(fragmentTransaction, TAG_GIFT_VERTICAL_DIALOG);

            }
        });
    }

}
