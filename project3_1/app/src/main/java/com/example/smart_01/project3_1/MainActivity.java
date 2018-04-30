package com.example.smart_01.project3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar mprogStatus;
    Button btnDecrease1, btnIncrease1, btnResult;

    //Rating 추가
    Button btnDecrease2, btnIncrease2;
    RatingBar mRatingVote;

    //seekbar 추가
    SeekBar mseekRed;
    View mViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id찾기
        mprogStatus = (ProgressBar) findViewById(R.id.progStatus);

        //감소 증가 하기 위한 버튼에 클릭
        btnDecrease1 = (Button) findViewById(R.id.btnDecrease1);
        btnIncrease1 = (Button) findViewById(R.id.btnIncrease1);

        //Rating에 대한 id찾기
        mRatingVote = (RatingBar) findViewById(R.id.ratingVote);
        btnDecrease2 = (Button) findViewById(R.id.btnDecrease2);
        btnIncrease2 = (Button) findViewById(R.id.btnIncrease2);
        btnResult = (Button) findViewById(R.id.btnResult);

        // seekbar id 찾기
        mseekRed = (SeekBar) findViewById(R.id.seekRed);
        mViewColor = (View) findViewById(R.id. viewColor);

        //기본 배경 색상
        mseekRed.setBackgroundColor(Color.argb(255, mseekRed.getProgress(), 0, 0));




        btnDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogStatus.setProgress(mprogStatus.getProgress()-5);
            }
        });

        btnIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogStatus.setProgress(mprogStatus.getProgress()+5);
            }
        });

        btnDecrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(-1);
            }
        });

        btnIncrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(1);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "현재값"+mRatingVote.getRating(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //seekbar 이벤트
        mseekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mViewColor.setBackgroundColor(Color.argb(255,progress,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}
