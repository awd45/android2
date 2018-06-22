package com.example.smart_01.exam1_1820340063;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.Fragment;



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
        setTitle("1번 문제");

        listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("컵케익", "3.5", R.drawable.cupcake));
        adapter.addItem(new SingerItem("도넛", "3.8", R.drawable.donut));
        adapter.addItem(new SingerItem("젤리빈", "2.8", R.drawable.jellybean));
        adapter.addItem(new SingerItem("롤리팝", "4.0", R.drawable.lollipop));


        // 위의 코드를 adapter에 할당
        listView.setAdapter(adapter);

        // Listitem을 클릭 할때 마다 토스트 출력
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "2018.6.22(제작:이동근)" , Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "로그인");
        menu.add(0, 2, 0, "소개");

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast tMsg = Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT);
                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, 100, 300);
                tMsg.show();

                return true;

            case 2:
                Toast.makeText(getApplicationContext(), "2018.6.22(제작:이동근)", Toast.LENGTH_SHORT).show();

                return true;

        }
        return false;

    }


    // 사용자 정의 리스트 뷰
    class SingerAdapter extends BaseAdapter {

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
        public void addItem(SingerItem item) {
            items.add(item); // ArrayList에서 추가 add, remove(제거), size(크기), get(값알아보보
        }

    }
}

