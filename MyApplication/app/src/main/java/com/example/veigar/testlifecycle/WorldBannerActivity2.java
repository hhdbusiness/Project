package com.example.veigar.testlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Veigar on 16/10/10.
 */

public class WorldBannerActivity2 extends Activity {

    private WorldBannerManager worldBannerManager;
    private RelativeLayout rl_world_view;
    private Button btn_add;
    private int current = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_world_banner);

        rl_world_view = (RelativeLayout)findViewById(R.id.rl_world_view);
        worldBannerManager = new WorldBannerManager(this, rl_world_view);
        btn_add = (Button)findViewById(R.id.btn_add);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorldBannerEntity worldBannerEntity = new WorldBannerEntity();
                worldBannerEntity.gainer = current + " " + current + " " + current + " " + current + " " + current + " " + current;
                worldBannerEntity.sender = current + " " + current + " " + current + " " + current + " " + current + " " + current;
                worldBannerEntity.gift_num = "123";
                worldBannerEntity.gift_name = current + " " + current + " " + current + " " + current + " " + current + " " + current;
                worldBannerManager.showWorldBanner(worldBannerEntity);
                current++;
            }
        });
        WorldBannerEntity worldBannerEntity = new WorldBannerEntity();
        worldBannerEntity.gainer = "111111111";
        worldBannerEntity.sender = "1111111111";
        worldBannerEntity.gift_num = "100";
        worldBannerEntity.gift_name = "1111111111";
        worldBannerManager.showWorldBanner(worldBannerEntity);
        WorldBannerEntity worldBannerEntity2 = new WorldBannerEntity();
        worldBannerEntity2.gainer = "2222222222";
        worldBannerEntity2.sender = "2222222222";
        worldBannerEntity2.gift_num = "200";
        worldBannerEntity2.gift_name = "2222222222";
        worldBannerManager.showWorldBanner(worldBannerEntity2);

    }
}
