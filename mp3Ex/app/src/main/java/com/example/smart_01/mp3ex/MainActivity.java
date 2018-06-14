package com.example.smart_01.mp3ex;

import android.Manifest;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 변수 선언
    ListView listViewMp3;
    Button btnPlay, btnStop;
    TextView tvMp3;

    ArrayList<String> mp3List; // 배열 ==> ArrayAdapter 연결
    String selectedMP3; // 선택한 음악 이름 표시 변수

    String mp3Path = Environment.getExternalStorageDirectory() + "/Music/";
    // 외장 디바이스의 기본 경로 값을 찾아옴 ==> SDcard, storage/emulator
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mp3플레이어");
        // 외부 저장 장치 접근 권한 ==> android Manifest.xml에서 한다.
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);



        // 파일경로찾기
        mp3List = new ArrayList<String>();

        // File 클래스 사용
        File[] listFiles = new File(mp3Path).listFiles();
        // listFiles() : 해당 경로 폴더안에 있는 모든 파일을 컬렉션 타입으로
        String fileName, extName; // 파일이름, 확장자 저장변수
       for(File file : listFiles){
            fileName = file.getName(); // getName() : 파일 이름
            extName = fileName.substring(fileName.length() -3); // 시작위치부터 끝까지 추출
            if(extName.equals((String) "mp3")) {
                mp3List.add(fileName); // ArrayList에 추가
            }

        }
        listViewMp3 = (ListView)findViewById(R.id.listViewMp3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);

        listViewMp3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMp3.setAdapter(adapter); // 리스트뷰와 Arrayadapter  연결
        listViewMp3.setItemChecked(0,true); // 첫번째값 디폴트

        listViewMp3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedMP3 = mp3List.get(position);
            }
        });

        selectedMP3=mp3List.get(0); // 첫번째 노래로 디폴트

        // 재생, 정지 기능
        // id 찾기
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnStop = (Button)findViewById(R.id.btnStop);
        tvMp3 = (TextView)findViewById(R.id.tvMp3);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3);
                    mPlayer.prepare(); // 재생준비
                    mPlayer.start(); // 재생
                    btnPlay.setClickable(false);  // 비활성화
                    btnStop.setClickable(true); // 활성화
                    tvMp3.setText("실행중인 음악 : "+selectedMP3);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
      btnStop.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mPlayer.stop();
              mPlayer.reset();
              btnPlay.setClickable(true);
              btnStop.setClickable(false);
              tvMp3.setText("실행중인 음악 : ");
          }
      });
      btnStop.setClickable(false);



    }
}
