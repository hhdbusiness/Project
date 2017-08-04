package com.example.veigar.protector;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.veigar.testlifecycle.PersonRankData;
import com.example.veigar.testlifecycle.R;

/**
 * Created by Veigar on 16/12/3.
 */

public class SmallRankDialog extends Dialog {

    private Context context;
    private static PersonRankData personRankData;

    private SmallRankDialog(Context context, int themeResId) {
        super(context, themeResId);

        this.context = context;
        initData();
    }

    public static SmallRankDialog createDialog(Context context,PersonRankData personRankData){
        SmallRankDialog.personRankData = personRankData;
        SmallRankDialog smallRankDialog = new SmallRankDialog(context,R.style.dialog_dim);
        return smallRankDialog;
    }

    private void initData() {
        View contentView = View.inflate(context, R.layout.dialog_person_rank_protector, null);
        TextView tv_rank_num = (TextView)contentView.findViewById(R.id.tv_rank_num);
        tv_rank_num.setText(Html.fromHtml("第<big>"+personRankData.getRank()+"</big>名"));
        setContentView(contentView);
    }


}
