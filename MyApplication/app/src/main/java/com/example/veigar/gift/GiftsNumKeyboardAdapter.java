package com.example.veigar.gift;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.veigar.testlifecycle.R;

/**
 * Created by Veigar on 16/10/28.
 */

public class GiftsNumKeyboardAdapter extends BaseAdapter {

    private String[] numStrs = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "-2", "0", "-1"};

    @Override
    public int getCount() {
        return numStrs.length;
    }

    @Override
    public Object getItem(int position) {
        return numStrs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        KeyboardViewHolder keyboardViewHolder;
        if(convertView == null){
            convertView = View.inflate(parent.getContext(),R.layout.item_gifts_keyboard,null);
            keyboardViewHolder = new KeyboardViewHolder();
            keyboardViewHolder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            keyboardViewHolder.iv_delete = (ImageView) convertView.findViewById(R.id.iv_delete);
            convertView.setTag(keyboardViewHolder);
        }else{
            keyboardViewHolder = (KeyboardViewHolder)convertView.getTag();
        }
        keyboardViewHolder.tv_num.setVisibility(View.GONE);
        keyboardViewHolder.iv_delete.setVisibility(View.GONE);
        if(position == 9){
            keyboardViewHolder.tv_num.setVisibility(View.VISIBLE);
            keyboardViewHolder.tv_num.setBackgroundColor(Color.parseColor("#d2d5db"));
            keyboardViewHolder.tv_num.setCompoundDrawables(null,null,null,null);
        }else if(position == 11){
            keyboardViewHolder.iv_delete.setVisibility(View.VISIBLE);
            keyboardViewHolder.iv_delete.setBackgroundColor(Color.parseColor("#d2d5db"));
        }else{
            keyboardViewHolder.tv_num.setVisibility(View.VISIBLE);
            keyboardViewHolder.tv_num.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        if(position == 9 || position == 11){
            keyboardViewHolder.tv_num.setText("");
        } else {
            keyboardViewHolder.tv_num.setText(numStrs[position] + "");
        }
        return convertView;
    }

    private class KeyboardViewHolder{
        public TextView tv_num;
        public ImageView iv_delete;
    }
}
