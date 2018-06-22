package com.example.smart_01.intentreex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView textView3;
    Button backButton, infoButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView3 = (TextView) findViewById(R.id.textView3);
        backButton = (Button)findViewById(R.id.backButton);
        infoButton = (Button)findViewById(R.id.infoButton);

        // 받는 기능부터 넣는다.
        intent = getIntent(); // 보내온 인텐트를 받음
        processCommand(intent); // 사용자정의 메서드

        Toast.makeText(getApplicationContext(),"비번" + AppData.password, Toast.LENGTH_SHORT).show();

        // 버튼에 돌아가는 기능부여
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type", "menu");

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

        // 상세정보 들어가기
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),infoActivity.class);


                // 결과값 받을 경우 보내기만 할 경우 startActivity(intent)
               startActivity(intent);
            }
        });



    }

    public  void  processCommand(Intent intent){
        if(intent != null){
            String id = intent.getStringExtra("id");
            textView3.setText("사용자 : " + id + "님이 입장하셨습니다.");;
        }
    }



}
