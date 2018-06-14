package com.example.smart_01.diaryex;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName; // 날짜 정보

    myDBHelper myHelper; // DB접근
    SQLiteDatabase sqlDB; // SQL문 작성


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(" 일정 관리");

        dp = (DatePicker)findViewById(R.id.datePicker1);
        edtDiary = (EditText)findViewById(R.id.edtDiary);
        btnWrite = (Button)findViewById(R.id.btnWrite);

        // 날짜 객체 선언 ==> new Date 혹은 Calendar.getInstance() 클래스
        Calendar cal = Calendar.getInstance();

        final int cYear = cal.get(Calendar.YEAR); // 시스템의 년도 값을 추출
        final int cMonth = cal.get(Calendar.MONTH); // 월 추출 == > +1 해야함
        final int cDay = cal.get(Calendar.DAY_OF_MONTH); // 일 추출

        // 데이터베이스 초기화
        myHelper = new myDBHelper(this);
        sqlDB = myHelper.getWritableDatabase();  // 쓰기모드 지정
        myHelper.onUpgrade(sqlDB, 1, 2);
        sqlDB.close();

        // 날짜 정보 설정
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth +1)
                + "_" + Integer.toString(cDay);
        String str = readDiary(fileName);
        edtDiary.setText(str);
        btnWrite.setEnabled(true);

        // dataPicker 값 설정
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 날짜 정보
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth);
                String str = readDiary(fileName); // select문 ==> 메서드 정의
                edtDiary.setText(str);
                btnWrite.setEnabled(true); // 버튼 활성화

            }
        });

        // 삽입 기능
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnWrite.getText().toString() == "새로저장"){
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO myDiary VALUES ('" + fileName + "','" + edtDiary.getText().toString() + "');");
                    // insert into mydiary('2018-6-11', '내용');
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨",
                            Toast.LENGTH_SHORT).show();
                } else { // 수정일때
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE myDiary SET content = '"
                            + edtDiary.getText().toString()
                            + "'WHERE diaryDate = '" + fileName + "' ;");
                    // update mydiary set content = "내용" where diaryDate = "2018-6-11"
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "수정됨",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    // readDiary 메서드 정의
   public String readDiary(String fName){
        String diaryStr = null;
        sqlDB = myHelper.getReadableDatabase(); // select 문을 이용하기 위한 준비
        Cursor cursor; // 커서 위치 체크
        cursor = sqlDB.rawQuery("select * from myDiary where diaryDate='" + fName + "';", null);

        if (cursor == null){
            edtDiary.setHint("일기없음");
            btnWrite.setText("새로저장");
        } else {
            if(cursor.moveToFirst()== true){
                diaryStr = cursor.getString(1);
                btnWrite.setText("수정하기");
            } else {
                edtDiary.setHint("일기없음");
                btnWrite.setText("새로저장");
            }
        }
        cursor.close();
        sqlDB.close();

        return diaryStr;
    }





    // SQLiteOpenHelper 클래스 만들기
    public class myDBHelper extends SQLiteOpenHelper{
        // 생성자를 통해서 데이터베이스를 만들기
        public myDBHelper(Context context){
            super(context, "myDB", null,1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // 테이블 만들기
            db.execSQL("create table myDiary(diaryDate char(10) primary key, content varchar(500))");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 테이블 갱신 ==> 테이블 삭제후 새롭게 다시 생성
            db.execSQL("drop table if exists myDiary");
            onCreate(db);

        }
    }
}
