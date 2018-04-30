package com.example.smart_01.project1_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOk;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사진선택");

        //id찾기
        text1 = (TextView) findViewById(R. id. Text1);
        text2 = (TextView) findViewById(R. id. Text2);
        chkAgree = (CheckBox) findViewById(R.id. ChkAgree);
        rGroup1 = (RadioGroup)findViewById(R. id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R. id. RdoDog);
        rdoCat = (RadioButton) findViewById(R. id. RdoCat);
        rdoRabbit = (RadioButton) findViewById(R. id.RdoRabbit);
        btnOk = (Button) findViewById(R.id.BtnOk);
        imgPet = (ImageView) findViewById(R. id. ImgPet);

        //checkbox의 선택 유무 체크할 이벤트
        chkAgree. setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree. isChecked()==true)
                {
                    //isChecked : checked 속성값을 알아볼 때 사용
                    //화면에 보여주기
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else
                {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                }
            }
        });
        btnOk.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId())
                {
                    case R. id.RdoDog:
                    imgPet.setImageResource(R.drawable.dog);
                    //setImageresources ==> android:src동일 기능 ==> 이미지불러오기
                        break;

                    case R. id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R. id. RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                }

            }
        });
    }
}
