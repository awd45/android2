package com.example.smart_01.exam1_1820340063;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SingerItem extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
    }

    private String name;
    private String mobile;
    private int restId; // Drawble img

    // 생성자 만들기
    public SingerItem(String name, String mobile){
        this.name = name;
        this.mobile = mobile;
    }

    public SingerItem(String name, String mobile, int restId){
        this.name=name;
        this.mobile=mobile;
        this.restId=restId;
    }


    // getter /setter 추가

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }


    // 객체결과 메세지
    public  String toString(){
        String result = "이름 : " + name;
        result += "전화번호 : " + mobile;
        result += "이미지" + restId;

        return result;
    }


}
