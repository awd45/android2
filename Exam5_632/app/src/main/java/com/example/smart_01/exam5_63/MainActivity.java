package com.example.smart_01.exam5_63;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TabHost;

@SuppressWarnings("deprecation") //경고메시지 없앰
public class MainActivity extends TabActivity {

    WebView web1, web2, web3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //탭 정보 가져오기
        TabHost tabHost = getTabHost();

        //탭 위제에 들어갈 메뉴명
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1").setIndicator("소개");
        tabSpec1.setContent(R.id.Tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2").setIndicator("칼로리계산");
        tabSpec2.setContent(R.id.Tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3").setIndicator("스트레칭");
        tabSpec3.setContent(R.id.Tab3);
        tabHost.addTab(tabSpec3);


        tabHost.setCurrentTab(0);//첫 페이지

        //웹뷰에 연결될 내용
        web1 =  (WebView) findViewById(R.id.mweb1);
        web1.loadUrl("file:///android_asset/test.html");




    }
}