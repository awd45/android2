package com.example.smart_01.menuex1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        //id찾기
        baseLayout=(LinearLayout) findViewById(R.id.baseLayout);
        button1=(Button) findViewById(R.id.button);

    }

    //onCreateOptionMenu  =>  xml을 이용한 메뉴 구성
    public  boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        //menu1.xml 문서를 불러와서 넣기
        return true;

    }

    //메뉴 항목에 기능 부여
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.itemRed :
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen :
                baseLayout.setBackgroundColor(Color.GREEN);
                return  true;
            case R.id.itemBlue :
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;

            //배경색바꾸기
            case  R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;


        }



        return  false;
    }


}
