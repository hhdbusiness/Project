package com.example.veigar.gift;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.veigar.testlifecycle.R;

public class CustomGiftCountAdapter extends BaseAdapter {

    // String[] strs = new String[]{"1", "5", "10", "99", "999", "自定义"};
    String[] numStrs = new String[]{"1314", "666", "188", "10", "1"};
    String[] textStrs = new String[]{"一生一世", "玩得溜", "要抱抱", "十全十美", "一心一意"};

    private int listHeight = 0;

    @Override
    public int getCount() {
        return numStrs.length + 1;
    }

    @Override
    public String getItem(int position) {
        return numStrs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CustomGiftNumViewHolder customGiftNumViewHolder = null;
        if (null == convertView) {
            convertView = View.inflate(parent.getContext(),
                    R.layout.custom_gift_cnt_item, null);
            customGiftNumViewHolder = new CustomGiftNumViewHolder();
            customGiftNumViewHolder.tv_left = (TextView)convertView.findViewById(R.id.tv_left);
            customGiftNumViewHolder.tv_right = (TextView)convertView.findViewById(R.id.tv_right);
            customGiftNumViewHolder.tv_other_num = (TextView)convertView.findViewById(R.id.tv_other_num);
            convertView.setTag(customGiftNumViewHolder);
        }else{
            customGiftNumViewHolder = (CustomGiftNumViewHolder)convertView.getTag();
        }

        if(position == 0){
            convertView.setBackgroundResource(R.drawable.shape_stw_5_stc_e1e1e1_cotl_4_cotr_4_so_ffffff);
            customGiftNumViewHolder.tv_left.setVisibility(View.GONE);
            customGiftNumViewHolder.tv_right.setVisibility(View.GONE);
            customGiftNumViewHolder.tv_other_num.setVisibility(View.VISIBLE);
            customGiftNumViewHolder.tv_other_num.setText("其他数额");
        }else{
            if(position == numStrs.length){
                convertView.setBackgroundResource(R.drawable.shape_stw_5_stc_e1e1e1_cobl_4_cobr_4_so_ffffff);
            }else{
                convertView.setBackgroundResource(R.drawable.shape_stw_5_stc_e1e1e1_so_ffffff);
            }
            customGiftNumViewHolder.tv_left.setVisibility(View.VISIBLE);
            customGiftNumViewHolder.tv_right.setVisibility(View.VISIBLE);
            customGiftNumViewHolder.tv_other_num.setVisibility(View.GONE);
            customGiftNumViewHolder.tv_left.setText(numStrs[position-1]);
            customGiftNumViewHolder.tv_right.setText(textStrs[position-1]);
        }
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (null != onItemPressListener) {
                    onItemPressListener.onItemPress(position, numStrs[position]);
                }
            }
        });

        return convertView;
    }

    private class CustomGiftNumViewHolder{
        public TextView tv_left;
        public TextView tv_right;
        public TextView tv_other_num;
    }

    private OnItemPressListener onItemPressListener;

    public OnItemPressListener getOnItemPressListener() {
        return onItemPressListener;
    }

    public void setOnItemPressListener(OnItemPressListener onItemPressListener) {
        this.onItemPressListener = onItemPressListener;
    }

    public interface OnItemPressListener {
        void onItemPress(int position, String text);
    }

}