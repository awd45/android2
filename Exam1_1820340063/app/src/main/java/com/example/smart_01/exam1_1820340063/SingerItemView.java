package com.example.smart_01.exam1_1820340063;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

class SingerItemView extends LinearLayout{


    TextView textView, textView2;
    ImageView imageView;



    // 생성자fr
    public SingerItemView(Context context){
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init(context);
    }


    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.imageView);


    }



    // setter 메서드 생성

    public void setTextView(String name) {
        textView.setText(name);
    }

    public void setTextView2(String mobile) {
        textView2.setText(mobile);
    }

    public void setImageView(int restId) {
        imageView.setImageResource(restId);
    }





}