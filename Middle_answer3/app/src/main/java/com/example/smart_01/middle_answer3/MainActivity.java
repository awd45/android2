package com.example.smart_01.middle_answer3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //변수 선언
    EditText name, e1, e2, e3; // 이름, 아침, 점심, 저녁
    CheckBox c1; //시작함
    RadioGroup rgroup1; //라디오 버튼 그룹
    RadioButton r1, r2, r3; //라디오버튼 항목
    Button btn1; // 계산버튼
    TextView result; //결과 표시할 영역
    LinearLayout total; //전체묶어준 부분

    //계산에 이용될 변수
    String num1, num2, num3;
    Double total_calory, total_calory1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("모바일_중간");

        //id값 찾아서 변수에 저장하기
        name = (EditText) findViewById(R.id.name);
        c1 = (CheckBox) findViewById(R.id.c1);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);

        total = (LinearLayout) findViewById(R.id.total);
        rgroup1 = (RadioGroup) findViewById(R.id.rgroup1);
        btn1 = (Button) findViewById(R.id.btn1);
        result = (TextView) findViewById(R.id.result);


        //기능 부여==> 시작함
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (c1.isChecked() == true) {
                    total.setVisibility(View.VISIBLE);
                } else {
                    total.setVisibility(View.INVISIBLE);
                }


            }
        });

        //기능부여 ==> 입력한 값 계산
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = e1.getText().toString();
                num2 = e2.getText().toString();
                num3 = e3.getText().toString();
                total_calory = Double.parseDouble(num1) + Double.parseDouble(num2) + Double.parseDouble(num3);


                //라디오 버튼 체크 여부 선택
                switch (rgroup1.getCheckedRadioButtonId()) {

                    case R.id.r1:
                        total_calory1 = total_calory * 1.2;
                        result.setText(name.getText().toString() + "님의 총 칼로리 섭취량은: " + total_calory1.toString());
                        break;

                    case R.id.r2:
                        total_calory1 = total_calory * 1.35;
                        result.setText(name.getText().toString() + "님의 총 칼로리 섭취량은: " + total_calory1.toString());
                        break;

                    case R.id.r3:
                        total_calory1 = total_calory * 1.5;
                        result.setText(name.getText().toString() + "님의 총 칼로리 섭취량은: " + total_calory1.toString());
                        break;
                }
            }
        });


    }
}
