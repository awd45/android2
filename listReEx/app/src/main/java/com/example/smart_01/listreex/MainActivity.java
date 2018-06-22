package com.example.smart_01.listreex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;
    EditText editText, editText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("컵케익", "010-0000-0000", R.drawable.cupcake));
        adapter.addItem(new SingerItem("도넛", "010-0000-0000", R.drawable.donut));
        adapter.addItem(new SingerItem("젤리빈", "010-0000-0000", R.drawable.jellybean));
        adapter.addItem(new SingerItem("롤리팝", "010-0000-0000", R.drawable.lollipop));

        // 위의 코드를 adapter에 할당
        listView.setAdapter(adapter);

        // Listitem을 클릭 할때 마다 토스트 출력
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택" + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        // 추가 버튼 눌렀을때.. 추가되는 값.. ==> 실습 내용중에 동적으로 추가했던 것
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();
                SingerItem item = new SingerItem(name, mobile, R.drawable.froyo);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();
            }
        });

    }

    // 사용자 정의 리스트 뷰
    class SingerAdapter extends BaseAdapter{

        ArrayList<SingerItem> items = new ArrayList<>();


        @Override
        public int getCount() {
            return items.size();  // 총 갯수
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            final int  pos = position;
//            final Context context = parent.getContext();
//
//            if(convertView == null){
//                LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                convertView = inflater.inflate(R.layout.singer_item, parent,false);
//
//
//            }
//            SingerItem listItem = items.get(position);
            //name.setText(listItem.getName());


            SingerItemView view1 = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view1.setTextView(item.getName());
            view1.setTextView2(item.getMobile());
            view1.setImageView(item.getRestId());
            return view1;


        }

        // 추가 메서드
        public void addItem(SingerItem item){
            items.add(item); // ArrayList에서 추가 add, remove(제거), size(크기), get(값알아보보
        }

    }

}
