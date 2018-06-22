package com.example.smart_01.exam2_1820340063;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 변수 선언
    myDBHelper myHelper; // DB 정보 가져옴
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button  btnInsert, btnSelect;
    SQLiteDatabase sqlDB; // 가져온 DB에 접근하기 위한 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학생관리프로그램");

        // ID 찾기
        edtName = (EditText)findViewById(R.id.edtName);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        edtNameResult = (EditText)findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText)findViewById(R.id.edtNumberResult);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnSelect = (Button)findViewById(R.id.btnSelect);


        // DB 초기화 삭제하기
        myHelper = new myDBHelper(this);


        // insert 기능
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB= myHelper.getWritableDatabase();
                sqlDB.execSQL("insert into groupTBL values( '"+edtName.getText().toString() +"',"+ edtNumber.getText().toString() +");");
                // insert into groupTBL values('문자', '문자'
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"입력완료", Toast.LENGTH_SHORT).show();
            }
        });

        // select 기능
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("select * from groupTBL;",null);

                String strNames = "전공" + "\r\n" + "__________" + "\r\n";
                String strNumbers = "학점" + "\r\n" + "_______________" + "\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                // 다음 레코드 값을 있으면 해당 필드값 변수 저장
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);
                // 결과
                cursor.close();
                sqlDB.close();

            }
        });


    }





    public class myDBHelper extends SQLiteOpenHelper {
        // 생성자 ==> DB만들기


        // 자동생성 constructor
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            // 테이블 만들기 table 생성
            db.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //초기화 ==> 삭제하고 다시 테이블 생성
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);

        }
    }




}
