package com.example.smart_01.intentex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    TextView re_name, re_sex, re_sns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("전송된 데이터 결과화면");

        //id찾기
        re_name=(TextView) findViewById(R.id.re_name);
        re_sex=(TextView) findViewById(R.id.re_sex);
        re_sns=(TextView) findViewById(R.id.re_sns);


        //intent받기
        Intent it = getIntent();
        String str_name1=it.getStringExtra("it_name");
        re_name.setText(str_name1);


        String str_sex=it.getStringExtra("it_sex");
        re_sex.setText(str_sex);


        String str_sns=it.getStringExtra("it_sns");
        re_sns.setText(str_sns);


    }
}
