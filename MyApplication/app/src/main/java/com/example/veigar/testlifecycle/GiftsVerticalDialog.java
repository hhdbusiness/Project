package com.example.veigar.testlifecycle;

import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veigar.gift.CustomGiftCountAdapter;
import com.example.veigar.gift.GiftsNumKeyboardAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Veigar on 16/10/27.
 */

public class GiftsVerticalDialog extends DialogFragment {

    private String giftsStr = "{\n" +
            "code: 0,\n" +
            "data: [\n" +
            "{\n" +
            "giftId: \"227\",\n" +
            "giftName: \"棒棒糖\",\n" +
            "price: \"20\",\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"208264\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/227/227_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/227/227_big.gif\",\n" +
            "payType: 2,\n" +
            "vipPrice: 20,\n" +
            "priceNew: \"20\",\n" +
            "vipPriceNew: 20,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/227/227_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/227/227_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"232\",\n" +
            "giftName: \"桃心\",\n" +
            "price: 1,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"2264\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/232/232_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/232/232_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 1,\n" +
            "priceNew: 1,\n" +
            "vipPriceNew: 1,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/232/232_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/232/232_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"229\",\n" +
            "giftName: \"红包\",\n" +
            "price: 3,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"451\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/229/229_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/229/229_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 2.9,\n" +
            "priceNew: 3,\n" +
            "vipPriceNew: 2.9,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/229/229_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/229/229_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"202\",\n" +
            "giftName: \"拍仔\",\n" +
            "price: 5,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"183\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/202/202_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/202/202_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 4.9,\n" +
            "priceNew: 5,\n" +
            "vipPriceNew: 4.9,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/202/202_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/202/202_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"233\",\n" +
            "giftName: \"元宝\",\n" +
            "price: 10,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"173\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/233/233_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/233/233_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 9.8,\n" +
            "priceNew: 10,\n" +
            "vipPriceNew: 9.8,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/233/233_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/233/233_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"201\",\n" +
            "giftName: \"666\",\n" +
            "price: 5,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"994\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/201/201_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/201/201_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 4.9,\n" +
            "priceNew: 5,\n" +
            "vipPriceNew: 4.9,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/201/201_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/201/201_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"231\",\n" +
            "giftName: \"皇冠\",\n" +
            "price: 100,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"69\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/231/231_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/231/231_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 98,\n" +
            "priceNew: 100,\n" +
            "vipPriceNew: 98,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/231/231_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/231/231_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"206\",\n" +
            "giftName: \"私人飞机\",\n" +
            "price: 250,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"25\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/206/206_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/206/206_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 245,\n" +
            "priceNew: 250,\n" +
            "vipPriceNew: 245,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/206/206_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/206/206_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"230\",\n" +
            "giftName: \"蓝色妖姬\",\n" +
            "price: 1,\n" +
            "unit: \"朵\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"1074\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/230/230_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/230/230_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 1,\n" +
            "priceNew: 1,\n" +
            "vipPriceNew: 1,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/230/230_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/230/230_b24.png\"\n" +
            "},\n" +
            "{\n" +
            "giftId: \"228\",\n" +
            "giftName: \"肥皂\",\n" +
            "price: 3,\n" +
            "unit: \"个\",\n" +
            "minNum: \"0\",\n" +
            "maxNum: \"0\",\n" +
            "total: \"0\",\n" +
            "limiter: \"0\",\n" +
            "startTime: \"0\",\n" +
            "endTime: \"0\",\n" +
            "discount: \"0\",\n" +
            "saleNum: \"124\",\n" +
            "pos: \"0\",\n" +
            "img_app_im: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/228/228_app_im.png\",\n" +
            "img_big_gif: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/228/228_big.gif\",\n" +
            "payType: 1,\n" +
            "vipPrice: 2.9,\n" +
            "priceNew: 3,\n" +
            "vipPriceNew: 2.9,\n" +
            "big: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/228/228_app.png\",\n" +
            "small: \"http://resimg.aipai.com/app/www/templates/common/img/upload/gift/228/228_b24.png\"\n" +
            "}\n" +
            "]\n" +
            "}";

    private static final int NUM_PER_PAGE = 8;
    private ArrayList<ArrayList<GiftInfo>> mAllPagesGiftInfos = new ArrayList<>();
    //    private ListView lv_custom_num;
    private TextView tv_gift_num;
    private LinearLayout ll_bottom;
    private int screenHeight;
    private int screenWidth;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showGiftsNumKeyboard();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.dialog_no_dim);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.dialog_gifts_vertical, container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        lv_custom_num = (ListView) view.findViewById(R.id.lv_custom_num);
        tv_gift_num = (TextView) view.findViewById(R.id.tv_gift_num);
        ll_bottom = (LinearLayout) view.findViewById(R.id.ll_bottom);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window mWindow = getDialog().getWindow();
        mWindow.setGravity(Gravity.BOTTOM);
        mWindow.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();

        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        initData();
    }

    private void initData() {
//        showAuthorDetailDialog();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    handler.sendEmptyMessage(123);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 作者详情对话框
     */
    private void showCustomNumDialog() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.popupwindow_video_detail_gifts_num, null);
//        Dialog giftNumDialog = new Dialog(getActivity(),R.style.dialog_no_dim);
        PopupWindow mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ListView lv_custom_num = (ListView) contentView.findViewById(R.id.lv_custom_num);
        CustomGiftCountAdapter mCustomGiftCountAdapter = new CustomGiftCountAdapter();
        mCustomGiftCountAdapter.setOnItemPressListener(new CustomGiftCountAdapter.OnItemPressListener() {

            @Override
            public void onItemPress(int position, String text) {
            }
        });
        lv_custom_num.setAdapter(mCustomGiftCountAdapter);
        mCustomGiftCountAdapter.notifyDataSetChanged();

        mPopupWindow.setContentView(contentView);
        // 使其聚集
        mPopupWindow.setFocusable(true);
        // 设置允许在外点击消失
        mPopupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.showAtLocation(tv_gift_num, Gravity.BOTTOM, -100, 50);

//        giftNumDialog.setContentView(contentView);
//        Window mWindow = giftNumDialog.getWindow();
//        WindowManager.LayoutParams layoutParams = mWindow.getAttributes();
//        layoutParams.y = 506;
//        mWindow.setGravity(Gravity.BOTTOM|Gravity.LEFT);
//        mWindow.setAttributes(layoutParams);
//        mWindow.setLayout(252, ViewGroup.LayoutParams.WRAP_CONTENT);
//        giftNumDialog.show();
    }

    private void showGiftsNumKeyboard() {
        if(getActivity() != null) {
            View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_gifts_num_keyboard, null);
            Dialog giftKeyboardDialog = new Dialog(getActivity(), R.style.dialog_no_dim);
            GridView gv_keyboard = (GridView) contentView.findViewById(R.id.gv_keyboard);
            GiftsNumKeyboardAdapter giftsNumKeyboardAdapter = new GiftsNumKeyboardAdapter();
            gv_keyboard.setAdapter(giftsNumKeyboardAdapter);
            gv_keyboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getContext(),position+"",Toast.LENGTH_SHORT).show();
                }
            });
            giftKeyboardDialog.setContentView(contentView);
            Window mWindow = giftKeyboardDialog.getWindow();
            mWindow.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mWindow.setGravity(Gravity.BOTTOM);
            giftKeyboardDialog.show();
        }
    }

}
