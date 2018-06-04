package com.example.smart_01.gridviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    MyGridAdapter gAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드");

        // ID 찾기
        gv = (GridView)findViewById(R.id.gridView1);
        gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
}
