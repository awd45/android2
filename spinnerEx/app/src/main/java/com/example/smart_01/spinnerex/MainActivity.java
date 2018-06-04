package com.example.smart_01.spinnerex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 배열 선언
    final  String[] movie ={"목록1","목록2","목록3","목록4","목록5"};
    Spinner spinner;

    final Integer[] posterID = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("스피너 테스트");

        // id 찾기 스피너 위에서 선언되어있지 않을때 아래와 같이 선언과 아이디찾기를 동시에할수 있음
        //Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        // 위에 선언이 되어있으니까 아래와 같이 아이디 찾기만 해도 된다.
        spinner = (Spinner)findViewById(R.id.spinner1);


        // Arrayadapter 연결
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String >(this,android.R.layout.simple_spinner_item,movie);
        spinner.setAdapter(adapter);


        // 기능부여 ==> setOnItemSelectedList....
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
            public void onItemSelected(AdapterView<?> arge0, View arg1, int arge2, long arg3) {
                // 토스트 보여주기 넣기
//                Toast.makeText(getApplicationContext(), movie[position], Toast.LENGTH_SHORT).show();
                // 이미지뷰 넣어주기
                ImageView ivPoster = (ImageView)findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setPadding(5,5,5,5);
                ivPoster.setImageResource(posterID[arge2]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
