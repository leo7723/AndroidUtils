package com.willplus.leo.stronger.Utills;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.willplus.leo.stronger.R;

/**
 * Created by changliliao on 2017/6/11.
 */

public class ToolbarManager {
    public static final int RIGHT_TEXT=1;
    public static final int LEFT_TEXT_ONE=2;
    public static final int RIGHT_IMAGE_ONE=4;
    public static final int RIGHT_IMAGE_TWO=8;
    public static final int LEFT_TEXT_TWO=16;
    public static final int ALL_NULL=32;

    Toolbar toolbar;

    public ToolbarManager(Toolbar toolbar){
        this.toolbar=toolbar;
    }

    /**
     * 初始化选择哪些需要显示出来
     * @param FALG
     */
    public ToolbarManager initToolbar(int FALG){
        FALG=FALG|ALL_NULL;
        String mFlag=Integer.toBinaryString(FALG);
        String flagS[]=mFlag.trim().split("");
        if(flagS[5].equals("1"))
            toolbar.findViewById(R.id.toolbar_right_text).setVisibility(View.VISIBLE);
        if(flagS[4].equals("1"))
            toolbar.findViewById(R.id.toolbar_left_text_two).setVisibility(View.VISIBLE);
        if(flagS[3].equals("1"))
            toolbar.findViewById(R.id.toolbar_right_btn_one).setVisibility(View.VISIBLE);
        if(flagS[2].equals("1"))
            toolbar.findViewById(R.id.toolbar_right_btn_two).setVisibility(View.VISIBLE);
        if(flagS[1].equals("1"))
            toolbar.findViewById(R.id.toolbar_left_text_one).setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置监听
     * @param listener
     */
    public ToolbarManager setOnClickListener(View.OnClickListener listener){
        toolbar.findViewById(R.id.toolbar_left_text_one).setOnClickListener(listener);
        toolbar.findViewById(R.id.toolbar_left_text_two).setOnClickListener(listener);
        toolbar.findViewById(R.id.toolbar_right_btn_one).setOnClickListener(listener);
        toolbar.findViewById(R.id.toolbar_right_btn_two).setOnClickListener(listener);
        toolbar.findViewById(R.id.toolbar_right_text).setOnClickListener(listener);
        return this;
    }

    /**
     * 设置顶部标题
     * @param title
     */
    public ToolbarManager setTopTitle(String title){
        TextView textView;
        textView= (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setText(title);
        return this;
    }

    public ToolbarManager setRightImageOne( Context context,int r){
        ImageView view= (ImageView) toolbar.findViewById(R.id.toolbar_right_btn_one);
        view.setImageDrawable(context.getResources().getDrawable(r));
        return this;
    }
}
