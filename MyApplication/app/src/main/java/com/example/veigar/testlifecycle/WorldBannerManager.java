package com.example.veigar.testlifecycle;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Veigar on 16/9/23.
 */

public class WorldBannerManager implements IWorldBannerManager {

    private FrameLayout fl_world_banner;
    private FrameLayout fl_world_banner2;
    private TextView tv_sender, tv_gainer, tv_gift_name, tv_gift_num;
    private TextView tv_sender2, tv_gainer2, tv_gift_name2, tv_gift_num2;
    private boolean isFirst = true;
    private int currentIndex = 0;
    private ExecutorService singleThreadExecutor;
    private int screenWidth;
    private static final long DOUBLE_PRESS_INTERVAL = 5000; // in millis
    private long lastPressTime;
    private boolean isEndAnimation = true;
    private ArrayList<WorldBannerEntity> worldBannerEntityArray = new ArrayList<>();
    private ArrayList<WorldBannerEntity> nextWorldBannerEntityArray = new ArrayList<>();
    private LinearLayout currentIdle = null;
    private boolean nextShow = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100: {
//                    currentIndex++;
                    /*if (worldBannerEntityArray.size() > currentIndex) {
                        WorldBannerEntity worldBannerEntity = worldBannerEntityArray.get(currentIndex);
                        tv_sender2.setText(worldBannerEntity.sender);
                        tv_gainer2.setText(worldBannerEntity.gainer);
                        tv_gift_num2.setText(worldBannerEntity.gift_num);
                        tv_gift_name2.setText(worldBannerEntity.gift_name);
                        showAnimation(ll_world_banner);
                    } else if (worldBannerEntityArray.size() == currentIndex) {
                        showAnimation(ll_world_banner);
                    }*/
                    if (worldBannerEntityArray.size() >= currentIndex) {
                        showAnimation(fl_world_banner);
                    }
                }
                break;
                case 200:
//                    currentIndex++;
                    /*if (worldBannerEntityArray.size() > currentIndex) {
                        WorldBannerEntity worldBannerEntity = worldBannerEntityArray.get(currentIndex);
                        tv_sender.setText(worldBannerEntity.sender);
                        tv_gainer.setText(worldBannerEntity.gainer);
                        tv_gift_num.setText(worldBannerEntity.gift_num);
                        tv_gift_name.setText(worldBannerEntity.gift_name);
                        showAnimation(ll_world_banner2);
                    } else if (worldBannerEntityArray.size() == currentIndex) {
                        showAnimation(ll_world_banner2);
                    }*/
                    if (worldBannerEntityArray.size() >= currentIndex) {
                        showAnimation(fl_world_banner2);
                    }
                    break;
            }
        }
    };

    public WorldBannerManager(Context context, ViewGroup worldView) {
//        this.worldView = worldView;
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(AipaiApplication.screenHeight, DensityUtil.dip2px(context,25), -3000, 0);
//        worldView.setLayoutParams(layoutParams);

        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;

        fl_world_banner = (FrameLayout) worldView.findViewById(R.id.fl_world_banner);
        fl_world_banner2 = (FrameLayout) worldView.findViewById(R.id.fl_world_banner2);
        tv_sender = (TextView) worldView.findViewById(R.id.tv_sender);
        tv_gainer = (TextView) worldView.findViewById(R.id.tv_gainer);
        tv_gift_name = (TextView) worldView.findViewById(R.id.tv_gift_name);
        tv_gift_num = (TextView) worldView.findViewById(R.id.tv_gift_num);
        tv_sender2 = (TextView) worldView.findViewById(R.id.tv_sender2);
        tv_gainer2 = (TextView) worldView.findViewById(R.id.tv_gainer2);
        tv_gift_name2 = (TextView) worldView.findViewById(R.id.tv_gift_name2);
        tv_gift_num2 = (TextView) worldView.findViewById(R.id.tv_gift_num2);

        tv_gift_name2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                if (isFirst) {
                    int middle = 0xFFFFB800;
                    int start = 0xFFFFFE00;
                    Shader shader = new LinearGradient(0, 0, 0, tv_gift_name2.getMeasuredHeight(), new int[]{start, middle},
                            new float[]{0f, 1f}, Shader.TileMode.CLAMP);
                    tv_gift_name.getPaint().setShader(shader);
                    tv_gift_name2.getPaint().setShader(shader);
                }
            }
        });

        singleThreadExecutor = Executors.newSingleThreadExecutor();

    }

    public void showWorldBanner(WorldBannerEntity worldBannerEntity) {

        /*tv_gift_name.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                if (isFirst) {
                    int middle = 0xFFFFB800;
                    int start = 0xFFFFFE00;
                    Shader shader = new LinearGradient(0, 0, 0, tv_gift_name.getMeasuredHeight(), new int[]{start, middle},
                            new float[]{0f, 1f}, Shader.TileMode.CLAMP);
                    tv_gift_name.getPaint().setShader(shader);
                    isFirst = false;

                    showAnimation(ll_world_banner,worldBannerEntity.screenWidth);
                }
            }
        });*/
        if (nextShow) {
            nextWorldBannerEntityArray.add(worldBannerEntity);
        } else {
            worldBannerEntityArray.add(worldBannerEntity);
        }
        if (isEndAnimation) {
            isEndAnimation = false;
            tv_sender.setText(worldBannerEntity.sender);
            tv_gainer.setText(worldBannerEntity.gainer);
            tv_gift_num.setText(worldBannerEntity.gift_num);
            tv_gift_name.setText(worldBannerEntity.gift_name);

            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        handler.sendEmptyMessage(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (worldBannerEntityArray.size() > 1 && currentIndex == 0) {
            WorldBannerEntity tempWorldBannerEntity = worldBannerEntityArray.get(1);
            tv_sender2.setText(tempWorldBannerEntity.sender);
            tv_gainer2.setText(tempWorldBannerEntity.gainer);
            tv_gift_num2.setText(tempWorldBannerEntity.gift_num);
            tv_gift_name2.setText(tempWorldBannerEntity.gift_name);
        }/*else if(worldBannerEntityArray.size() > 1 && currentIndex == 1){
            WorldBannerEntity tempWorldBannerEntity = worldBannerEntityArray.get(1);
            tv_sender2.setText(tempWorldBannerEntity.sender);
            tv_gainer2.setText(tempWorldBannerEntity.gainer);
            tv_gift_num2.setText(tempWorldBannerEntity.gift_num);
            tv_gift_name2.setText(tempWorldBannerEntity.gift_name);
        }else if(worldBannerEntityArray.size() > 2 && currentIndex == 2){
            WorldBannerEntity tempWorldBannerEntity = worldBannerEntityArray.get(2);
            tv_sender.setText(tempWorldBannerEntity.sender);
            tv_gainer.setText(tempWorldBannerEntity.gainer);
            tv_gift_num.setText(tempWorldBannerEntity.gift_num);
            tv_gift_name.setText(tempWorldBannerEntity.gift_name);
        }*/
//        showAnimation(ll_world_banner,worldBannerEntity.screenWidth);

    }

    public void nextShowWorldBanner() {

        if(worldBannerEntityArray.size() > 1) {
            WorldBannerEntity worldBannerEntity = worldBannerEntityArray.get(0);
            tv_sender.setText(worldBannerEntity.sender);
            tv_gainer.setText(worldBannerEntity.gainer);
            tv_gift_num.setText(worldBannerEntity.gift_num);
            tv_gift_name.setText(worldBannerEntity.gift_name);
            WorldBannerEntity worldBannerEntity2 = worldBannerEntityArray.get(1);
            tv_sender2.setText(worldBannerEntity2.sender);
            tv_gainer2.setText(worldBannerEntity2.gainer);
            tv_gift_num2.setText(worldBannerEntity2.gift_num);
            tv_gift_name2.setText(worldBannerEntity2.gift_name);
        }else if(worldBannerEntityArray.size() == 1){
            WorldBannerEntity worldBannerEntity = worldBannerEntityArray.get(0);
            tv_sender.setText(worldBannerEntity.sender);
            tv_gainer.setText(worldBannerEntity.gainer);
            tv_gift_num.setText(worldBannerEntity.gift_num);
            tv_gift_name.setText(worldBannerEntity.gift_name);
        }

        if (isEndAnimation) {
            isEndAnimation = false;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void showAnimation(final ViewGroup worldView/*,int screenWidth*/) {
        ValueAnimator animator = null;
//        if (AipaiApplication.screenHeight100 == screenWidth) {
        animator = ValueAnimator.ofFloat(0, 0 - worldView.getMeasuredWidth() - screenWidth);
//        } else {
//            animator = ValueAnimator.ofFloat(AipaiApplication.screenWidth - AipaiApplication.screenHeight
//                    , 0 - worldView.getMeasuredWidth() - screenWidth
//                            - (AipaiApplication.screenHeight - AipaiApplication.screenWidth));
//        }
        animator.setTarget(worldView);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(14000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (worldView.getVisibility() == View.INVISIBLE) {
                    worldView.setVisibility(View.VISIBLE);
                }

                worldView.setTranslationX((Float) animation.getAnimatedValue());
                /*float value = 0f - (float) worldView.getMeasuredWidth();
                float valueGap = value - (Float) animation.getAnimatedValue();
                long pressTime = System.currentTimeMillis();
                if (0 < valueGap && valueGap < 40 && pressTime - lastPressTime >= DOUBLE_PRESS_INTERVAL) {
                    if (worldView.equals(ll_world_banner)) {
                        handler.sendEmptyMessage(200);
                    } else {
                        handler.sendEmptyMessage(100);
                    }
                    lastPressTime = pressTime;
                }*/
                /*if(0 < valueGap && valueGap < 40 && worldBannerEntityArray.size() == currentIndex){
                    Log.e("WorldBannerManager","nextShow = true");
                    nextShow = true;
                }*/
            }

        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (worldView.getVisibility() == View.VISIBLE) {
                    worldView.setVisibility(View.INVISIBLE);
                }
                currentIndex++;
                if (worldView.equals(fl_world_banner) && worldBannerEntityArray.size() > currentIndex + 1) {
                    Log.e("WorldBannerManager", "onAnimationEnd one worldBannerEntityArray.size()"
                            + worldBannerEntityArray.size() + " currentIndex = " + currentIndex);
                    WorldBannerEntity worldBannerEntity = worldBannerEntityArray.get(currentIndex + 1);
                    tv_sender.setText(worldBannerEntity.sender);
                    tv_gainer.setText(worldBannerEntity.gainer);
                    tv_gift_num.setText(worldBannerEntity.gift_num);
                    tv_gift_name.setText(worldBannerEntity.gift_name);
//                    handler.sendEmptyMessage(200);
                }
                if (worldView.equals(fl_world_banner2) && worldBannerEntityArray.size() > currentIndex + 1) {
                    Log.e("WorldBannerManager", "onAnimationEnd two worldBannerEntityArray.size()"
                            + worldBannerEntityArray.size() + " currentIndex = " + currentIndex);
                    WorldBannerEntity worldBannerEntity = worldBannerEntityArray.get(currentIndex + 1);
                    tv_sender2.setText(worldBannerEntity.sender);
                    tv_gainer2.setText(worldBannerEntity.gainer);
                    tv_gift_num2.setText(worldBannerEntity.gift_num);
                    tv_gift_name2.setText(worldBannerEntity.gift_name);
//                    handler.sendEmptyMessage(100);
                }
                if(worldBannerEntityArray.size() > currentIndex){
                    if (worldView.equals(fl_world_banner)){
                        handler.sendEmptyMessage(200);
                    }else{
                        handler.sendEmptyMessage(100);
                    }
                }
                Log.e("WorldBannerManager", "onAnimationEnd three worldBannerEntityArray.size()"
                        + worldBannerEntityArray.size() + " currentIndex = " + currentIndex);
                if(worldBannerEntityArray.size() == currentIndex + 1){
                    Log.e("WorldBannerManager","nextShow = true");
                    nextShow = true;
                }
                /*if (worldView.equals(ll_world_banner)) {
                    handler.sendEmptyMessage(200);
                } else {
                    handler.sendEmptyMessage(100);
                }*/
                if (worldBannerEntityArray.size() == currentIndex) {
                    worldBannerEntityArray.removeAll(worldBannerEntityArray);
                    currentIdle = null;
                    currentIndex = 0;
                    isEndAnimation = true;
                    if (nextShow && nextWorldBannerEntityArray.size() > 0) {
                        Log.e("WorldBannerManager","nextShow = false");
                        nextShow = false;
                        worldBannerEntityArray.addAll(nextWorldBannerEntityArray);
                        nextShowWorldBanner();
                        nextWorldBannerEntityArray.removeAll(nextWorldBannerEntityArray);
                    }else{
                        nextShow = false;
                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

}
