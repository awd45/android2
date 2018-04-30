package com.example.smart_01.project1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button BMI;
    TextView textResult;
    String num1, num2;
    Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI계산기");

        edit1= (EditText) findViewById(R.id.Edit1);
        edit2= (EditText) findViewById(R.id.Edit2);
        BMI = (Button) findViewById(R.id.BMI);

        textResult= (TextView) findViewById(R.id.textResult);

        BMI.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                //getText() :
                //toString() :
                num2 = edit2.getText().toString();

                result = Float.parseFloat(num1)/ (Float.parseFloat(num2) * Float.parseFloat(num2));
                textResult.setText("BMI계산결과"+result.toString());

                if(result > 18.5) {
                    ("BMI계산결과" + "과체중");
                }
                else {
                        ("BMI계산결과"+"과체중");
                    }


                return false;
            }

        });


    }
}
