package com.example.smart_01.intentex4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Intent intent = getIntent();
        final int hapValue = intent.getIntExtra("Num1", 0)
                + intent.getIntExtra("Num2", 0);


        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //인텐트 새롭게 생성
                Intent outintent = new Intent(getApplicationContext(), MainActivity.class);
                outintent.putExtra("Hap", hapValue);

                //추가되는 부분
                setResult(RESULT_OK, outintent);
                finish();
            }
        });


    }
}
