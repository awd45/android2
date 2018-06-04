package com.example.smart_01.menuex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("자바로 직접 메뉴 만들기");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"로그인");
        menu.add(0,2,0,"로그아웃");

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                Toast tMsg = Toast.makeText(getApplicationContext(),"로그인선택", Toast.LENGTH_SHORT);
                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, 100,300);
                tMsg.show();

                return true;

            case 2:
                Toast.makeText(getApplicationContext(),"로그아웃선택", Toast.LENGTH_SHORT).show();

                return true;

        }
        return  false;

    }
}
