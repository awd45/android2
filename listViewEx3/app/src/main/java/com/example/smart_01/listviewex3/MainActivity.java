package com.example.smart_01.listviewex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mList1, mList2;
    ArrayList<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트3");


        // 동적 배열로 목록 추가
        mData.add("a");
        mData.add("b");
        mData.add("c");
        mData.add("d");
        mData.add("e");
        mData.add("f");

        mData.add("가");
        mData.add("나");
        mData.add("다");
        mData.add("라");
        mData.add("마");
        mData.add("바");

        mList1=(ListView)findViewById(R.id.list1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mData);
        mList1.setAdapter(adapter1);

        mList2 = (ListView) findViewById(R.id.list2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.planet,android.R.layout.simple_list_item_1);
        mList2.setAdapter(adapter2);


//        mList2=(ListView) findViewById(R.id.list2);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mData);
//        mList2.setAdapter(adapter2);

        //리스트를 클릭했을때의 메시지는 각각 넣기


    }
}
