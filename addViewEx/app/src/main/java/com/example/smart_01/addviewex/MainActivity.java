package com.example.smart_01.addviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //아이디 찾기
    Button btn1, btn2;
    CalendarView cal1;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id찾기
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        cal1 = (CalendarView) findViewById(R.id.cal1);
        layout = (LinearLayout) findViewById(R.id.layout);
        // 텍스트뷰를 추가
        TextView name=new TextView(this);
        name.setText("추가하는 텍스트");
        name.setTextSize(20);
        layout.addView(name); // Layout 이라는 공간에 추가하기

        Button button1 = new Button(this);
        button1.setText("동적으로 추가된 버튼");
        layout.addView(button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //하나만 제거
                layout.removeView(cal1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //모두 제거
                layout.removeAllViews();
            }
        });












    }
}
