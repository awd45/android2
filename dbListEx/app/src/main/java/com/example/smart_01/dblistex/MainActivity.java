package com.example.smart_01.dblistex;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arr; // 배열만들기
    myDBHelper myHelper; // DB연결하기
    SQLiteDatabase sqlDB; // SQL문 작성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("DB정보를 리스트로 보여주기");

        arr = new ArrayList<>();
        myHelper = new myDBHelper(this); // DB 생성하고 접근
        sqlDB = myHelper.getWritableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("select username from db_user", null);
        cursor.moveToFirst();
        cursor.getCount();

        // ArrayList에 값 추가
        for(int i = 0; i < cursor.getCount(); i++){
            arr.add(cursor.getString(0)); // DB에서 가져온 값을 arrayList추가
            cursor.moveToNext();
        }

        ListView list = (ListView)findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arr);
        list.setAdapter(adapter); // 리스트와 어댑터 연결

    }

    public class myDBHelper extends SQLiteOpenHelper{
        // 생성자
        public myDBHelper(Context context){
            super(context, "myDB1", null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            // 테이블 작성
            db.execSQL("create table db_user"  +
                    "(userid text primary key, username text, usernumber text)");

            // 레코드값 삽입
            db.execSQL("insert into db_user values ('user1', '홍길동', '101');");
            db.execSQL("insert into db_user values ('user2', '홍성흔', '101');");
            db.execSQL("insert into db_user values ('user3', '강민호', '101');");
            db.execSQL("insert into db_user values ('user4', '양승호', '101');");
            db.execSQL("insert into db_user values ('user5', '장원준', '101');");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("drop table if exists db_user");
            onCreate(db);
        }
    }
}
