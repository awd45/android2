package com.example.smart_01.mediaplayerex3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    MediaPlayer mPlayer1,mPlayer2,mPlayer3,mPlayer4,mPlayer5,mPlayer6,mPlayer7,mPlayer8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("실로폰");

        mPlayer1 = MediaPlayer.create(MainActivity.this,R.raw.song1);
        mPlayer1.setLooping(false);
        mPlayer2 = MediaPlayer.create(MainActivity.this,R.raw.re);
        mPlayer2.setLooping(false);
        mPlayer3 = MediaPlayer.create(MainActivity.this,R.raw.mi);
        mPlayer3.setLooping(false);
        mPlayer4 = MediaPlayer.create(MainActivity.this,R.raw.fa);
        mPlayer4.setLooping(false);
        mPlayer5 = MediaPlayer.create(MainActivity.this,R.raw.sol);
        mPlayer5.setLooping(false);
        mPlayer6 = MediaPlayer.create(MainActivity.this,R.raw.ra);
        mPlayer6.setLooping(false);
        mPlayer7 = MediaPlayer.create(MainActivity.this,R.raw.si);
        mPlayer7.setLooping(false);
        mPlayer8 = MediaPlayer.create(MainActivity.this,R.raw.do_h);
        mPlayer8.setLooping(false);

        // btn 찾기
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer1.isPlaying()){
                    mPlayer1.pause();
                } else {
                    mPlayer1.start();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer2.isPlaying()){
                    mPlayer2.pause();
                } else {
                    mPlayer2.start();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer3.isPlaying()){
                    mPlayer3.pause();
                } else {
                    mPlayer3.start();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer4.isPlaying()){
                    mPlayer4.pause();
                } else {
                    mPlayer4.start();
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer5.isPlaying()){
                    mPlayer5.pause();
                } else {
                    mPlayer5.start();
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer6.isPlaying()){
                    mPlayer6.pause();
                } else {
                    mPlayer6.start();
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer7.isPlaying()){
                    mPlayer7.pause();
                } else {
                    mPlayer7.start();
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mPlayer8.isPlaying()){
                    mPlayer8.pause();
                } else {
                    mPlayer8.start();
                }
            }
        });

    }
}
