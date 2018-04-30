package com.example.smart_01.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사진선택");

        //id찾기
        text1 = (TextView) findViewById(R. id. Text1);
        text2 = (TextView) findViewById(R. id. Text2);
        chkAgree = (checkBox) findViewById(R.id.chkAgree);
        rGroup1 = (RadioGroup)findViewById(R. id.Rgroup1);
        rdoDog = (radioButton) findViewById(R. id. RdoDog);
        rdocat = (radioButton) findViewById(R. id. Rdcat);
        rdoRabbit = (RadioButton) findViewById(R. id.RdoRabbitt);
        btnOK = (Button) findViewById(R.id.BtnOk);
        imgPet = (ImageView) findViewById(R. id. ImgPet);


        //checkbox의 선택 유무 체크할 이벤트
        chkAgree. setOnCheckedChangeListener(new compoundButton.onCheckedChangeLstenner(){
            //서택을 변경할때 발생하는 이벤트 리스너 등록
            @Override
            protected void onCheckedchanged(compoundButton buttonView, boolean isChecked){
                //이벤트 핸들러

                if(chkAgreee.ischecked()==true){
                    //ischecked : checked속성값을 알아볼때 사용
                    //화면에 보여주기 ==> visible이라는 속성값을 설정
                    text2.setVisibility(view.VISIBLE);
                    rGroup1.setVisibility(view.VISIBLE);
                    btnOK.setVisibility(view.VISIBLE);
                    imgPet.setVisibility(view.VISIBLE);
                }
            }
        });  // checkbox 영역에 대한 처리끝
        //선택완료 버튼에 클릭 이벤트 부여
        btnOK.setonClickListener(new View.OnClickListener(){
            @Override
            protected void onClick

        })




    }
}
