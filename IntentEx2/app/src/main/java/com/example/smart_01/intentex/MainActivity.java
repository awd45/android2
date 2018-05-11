package com.example.smart_01.intentex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    Button btn1;
    RadioButton rabtn1, rabtn2;
    RadioGroup gg;
    CheckBox chk_sns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("고객정보입력화면");


        //id찾기
        edit1 = (EditText) findViewById(R.id.edit1);
        btn1 = (Button) findViewById(R.id.btn1);
        gg = (RadioGroup) findViewById(R.id.gg);
        chk_sns = (CheckBox) findViewById(R.id.chk_sns);


        //기능 부여
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = edit1.getText().toString();

                rabtn1 = (RadioButton) findViewById(R.id.rabtn1);
                rabtn2 = (RadioButton) findViewById(R.id.rabtn2);
                String str_sex = "";
                if (rabtn1.isChecked() == true) {
                    str_sex = "남";
                }
                if (rabtn2.isChecked() == true) {
                    str_sex = "여";
                }
                String str_sns = "";
                if (chk_sns.isChecked()) {
                    str_sns = "수신함";
                }
                Intent it = new Intent(getApplicationContext(), ReceiveActivity.class);
                it.putExtra("it_name", str_name); // 변수명 = 값
                it.putExtra("it_sex", str_sex);
                it.putExtra("it_sns", str_sns);
                startActivity(it);
            }
        });
    }
}

