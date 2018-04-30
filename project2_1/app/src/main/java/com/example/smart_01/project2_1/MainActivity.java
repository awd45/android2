package com.example.smart_01.project2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnchange;
    ImageView View1;
    ImageView View2;
    int imageIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이미지바꾸기");


        //id찾기
        btnchange = (Button) findViewById(R.id.btnchange);
        View1=(ImageView) findViewById(R.id.imageView1);
        View2=(ImageView) findViewById(R.id.imageView2);

        //버튼에 기능 부여
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메소드 호출
                if (imageIndex==0){
                    View1.setVisibility(View.VISIBLE);
                    View2.setVisibility(View.INVISIBLE);
                    imageIndex=1;
                } else if(imageIndex==1){
                    View1.setVisibility(View.INVISIBLE);
                    View2.setVisibility(View.VISIBLE);
                    imageIndex=0;
                }
            }
        });
    }
    //public void changeImage() {
    // 처리할 코드
    //}
}

