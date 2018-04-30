package com.example.smart_01.project2_6;


import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TabHost;

@SuppressWarnings("deprecation") //경고메시지 없앰
public class MainActivity extends TabActivity {

    WebView web1, web2, web3, web4, web5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //탭 정보 가져오기
        TabHost tabHost = getTabHost();

        //탭 위제에 들어갈 메뉴명
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1").setIndicator("학과소개");
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2").setIndicator("교육과정");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3").setIndicator("학사안내");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);

        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("Tab4").setIndicator("커뮤니티");
        tabSpec4.setContent(R.id.tab4);
        tabHost.addTab(tabSpec4);

        TabHost.TabSpec tabSpec5 = tabHost.newTabSpec("Tab5").setIndicator("취업&진로");
        tabSpec5.setContent(R.id.tab5);
        tabHost.addTab(tabSpec5);

        tabHost.setCurrentTab(0);//첫 페이지

        //웹뷰에 연결될 내용
        web1 =  (WebView) findViewById(R.id.mweb1);
        web1.loadUrl("file:///android_asset/dm1.html");

        web2 =  (WebView) findViewById(R.id.mweb2);
        web2.loadUrl("file:///android_asset/dm2.html");

        web3 =  (WebView) findViewById(R.id.mweb3);
        web3.loadUrl("file:///android_asset/dm3.html");

        web4 =  (WebView) findViewById(R.id.mweb4);
        web4.loadUrl("file:///android_asset/dm4.html");

        web5 =  (WebView) findViewById(R.id.mweb5);
        web5.loadUrl("file:///android_asset/dm5.html");

    }
}
