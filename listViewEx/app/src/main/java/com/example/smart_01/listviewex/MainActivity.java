package com.example.smart_01.listviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 이용1");

        // 1> 리스트뷰에 나열될 내용을 string 배열로
        final String[] mid={"목록1", "목록2", "목록3", "목록4", "목록5", "목록6", "목록7", "목록8", "목록9", "목록10", "목록11"};

        // 2> 리스트뷰 찾기
        ListView list = (ListView)findViewById(R.id.listView1);

        // 3> ArrayAdpqter : 리스트뷰로 작성된 값과 배열 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mid);

        // 1) arrayadpter의 값을 보여줄 객체
        // 2) 모양
        // 3) 배열
        // 체크모드 사용해보기
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);
        // 4> 리스트뷰에 array어댑터 연결

        // 5> 리스트뷰의 기능 연결
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), mid[position], Toast.LENGTH_SHORT).show();

            }
        });


    }
}
