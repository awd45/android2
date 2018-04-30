package com.example.smart_01.exinflation1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    CheckBox checkBox, checkBox2;
    LayoutInflater inflater;
    LinearLayout container;
    ImageView image1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 주 메인 화면

        container = (LinearLayout) findViewById(R.id.container);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        //버튼에 기능 부여
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //getSystemService(): 전체화면중에 일부분을 사용

                inflater.inflate(R.layout.sub1, container, true);

                //부분화면의 역할
                checkBox=(CheckBox) container.findViewById(R.id.checkBox);
                checkBox.setText("로딩됨");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //getSystemService(): 전체화면중에 일부분을 사용

                inflater.inflate(R.layout.sub2, container, true);

                //부분화면의 역할
                checkBox2=(CheckBox) container.findViewById(R.id.checkBox2);
                checkBox2.setText("로딩됨2");

                image1=(ImageView) container.findViewById(R.id.image1);


            }
        });




    }
}
