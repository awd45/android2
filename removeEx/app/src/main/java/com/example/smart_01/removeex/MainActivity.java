package com.example.smart_01.removeex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //변수 선언
    RadioGroup radioGroup;
    LinearLayout layout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id 찾기
        layout = (LinearLayout) findViewById(R.id.layout);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sub1, null);
        layout.addView(view);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View view = null;
                if(i==R.id.radioButton1) {
                    Toast.makeText(getApplicationContext(), "교수화면", Toast.LENGTH_SHORT).show();
                    view = inflater.inflate(R.layout.sub1, null);
                }else if (i==R.id.radioButton2){
                    Toast.makeText(getApplicationContext(),"학생화면", Toast.LENGTH_SHORT).show();
                    view = inflater.inflate(R.layout.sub2, null);
                }
                layout.removeAllViews();
                layout.addView(view);

            }
        });

    }
}
