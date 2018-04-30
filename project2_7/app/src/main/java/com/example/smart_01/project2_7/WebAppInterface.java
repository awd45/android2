package com.example.smart_01.project2_7;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;

    WebAppInterface(Context c){
        mContext =c;
    }
    //매서드정의 ==> 자바스크립트에서 안드로이드 메서드 호출

    @JavascriptInterface
    public void showToast (String toast){
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

}
