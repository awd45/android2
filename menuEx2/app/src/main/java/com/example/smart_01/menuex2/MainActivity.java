package com.example.smart_01.menuex2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    LinearLayout baseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("컨텍스트 메뉴");
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1); // 컨텍스트메뉴를 나오게 할 대상
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        //메뉴 인플레이트 등록
        MenuInflater mInflater = getMenuInflater();
        if (v == button1) {
            mInflater.inflate(R.menu.menu1, menu);
        }
        if (v == button2) {
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;

            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.subRotate:
                baseLayout.setRotation(45);
                return true;

            case R.id.subSize:
                button1.setScaleX(2);
                return true;

        }
        return false;
    }
}
