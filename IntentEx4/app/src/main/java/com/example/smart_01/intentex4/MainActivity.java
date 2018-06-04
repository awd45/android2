package com.example.smart_01.intentex4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("메인");

        Button btn1 = (Button) findViewById(R.id.btn1);
        editNum1 = (EditText) findViewById(R.id.editNum1);
        editNum2 = (EditText) findViewById(R.id.editNum2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인텐트 실행
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));
                //달라지는 부분
                startActivityForResult(intent, 0);
            }
        });


    }
    //메인으로 돌아왔을때 메서드 오버라이딩
    //code -> override methods==> onActivityResult
    protected void onActivityResult(int requstCode, int resultCode, Intent data){
        //성공여부 체크후 결과 출력
        if(resultCode== RESULT_OK){
            int hap = data.getIntExtra("Hap",0);
            Toast.makeText(getApplicationContext(), "합계"+hap, Toast.LENGTH_SHORT).show();
        }


    }


}
