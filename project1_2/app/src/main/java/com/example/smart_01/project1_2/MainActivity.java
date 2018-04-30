package com.example.smart_01.project1_2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //위젯에 따른 사용할 변수 선언.. 데이터타입 변수명; ==> 데이터타입(기본형(8개), 참조형:클래스)

    EditText edit1, edit2;
    Button btnAdd, btnSub,btnMul,btnDiv, BMI;
    TextView textResult;
    String num1, num2;
    Integer result;
    Float result2; // parseFloat



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 계산기");

        //xml에 있는 ID값 찾기
        edit1= (EditText) findViewById(R.id.Edit1);
        edit2= (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);


        textResult= (TextView) findViewById(R.id.textResult);

        //기능부여 ==> 이벤트==> onTouchlisner
      btnAdd.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              num1=edit1.getText().toString();
              //getText() :
              //toString() :
              num2 = edit2.getText().toString();

              result = Integer.parseInt(num1)+Integer.parseInt(num2);
              textResult.setText("계산결과"+result.toString());

              return false;
          }
      });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                //getText() :
                //toString() :
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1)-Integer.parseInt(num2);
                textResult.setText("계산결과"+result.toString());

                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                //getText() :
                //toString() :
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1)*Integer.parseInt(num2);
                textResult.setText("계산결과"+result.toString());

                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                //getText() :
                //toString() :
                num2 = edit2.getText().toString();

                result2 = Float.parseFloat(num1)/ Float.parseFloat(num2);
                textResult.setText("계산결과"+result2.toString());

                return false;
            }
        });


    }
}

