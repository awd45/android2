package com.example.smart_01.menubuttonex;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    Button button1;
//    View dialogView;
//    TextView tvName, tvEmail;
//    EditText dlgEdtName,dlgEdtEmail;
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit, rdoHorse;
    Button btnImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("직접해보기");

        // id 찾기
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
        rdoHorse = (RadioButton) findViewById(R.id.rdoHorse);
        btnImage = (Button) findViewById(R.id.btnImage);

        final Integer[] radioID = {R.id.rdoDog, R.id.rdoCat, R.id.rdoRabbit, R.id.rdoHorse};
        final Integer[] petID = {R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse};

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rGroup.getCheckedRadioButtonId();
                View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView ivPet = (ImageView) dialogView.findViewById(R.id.ivPet);

                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoDog:
                        ivPet.setImageResource(petID[0]);
                        dlg.setTitle("강아지");
                        break;
                    case R.id.rdoCat:
                        ivPet.setImageResource(petID[1]);
                        dlg.setTitle("고양이");
                        break;
                    case R.id.rdoRabbit:
                        ivPet.setImageResource(petID[2]);
                        dlg.setTitle("토끼");
                        break;
                    case R.id.rdoHorse:
                        ivPet.setImageResource(petID[3]);
                        dlg.setTitle("말");
                        break;
                }
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

    }
}

//        tvName = (TextView)findViewById(R.id.tvName);
//        tvEmail = (TextView)findViewById(R.id.tvEmail);
//
//        button1 = (Button)findViewById(R.id.button1);

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // 1> 인플레이트 가져오기
//                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
//                //LayoutInflator inflater = getInflater();
//                //View dialogView = inflater.inflate(.., , ,);
//
//                // 2> AlertDialog 생성하기
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);


                // 3> 창 조절하기
//                dlg.setTitle("사용자 정보 입력창");


                // 4> setView로 연결하기 => setMessage, setItems 대신에 내가 만든 xml로
//                dlg.setView(dialogView);
//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
//                        dlgEdtEmail = (EditText)dialogView.findViewById(R.id.dlgEdt2);
//
//                        tvName.setText(dlgEdtName.getText().toString());
//                        tvEmail.setText(dlgEdtEmail.getText().toString());
//
//                    }
//                });
//
//                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),"취소되었습니다.",Toast.LENGTH_LONG).show();
//                    }
//                });



//                dlg.setPositiveButton("확인", null);
//                dlg.setPositiveButton("확인",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdtName);
//                                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdtEmail);
//
//                                tvName.setText(dlgEdtName.getText().toString());
//                                tvEmail.setText(dlgEdtEmail.getText().toString());
//                            }
//                        });
//                dlg.setNegativeButton("취소", null);
//
//                // 5> 보여주기
//                dlg.show();
//            }
//        });
//    }
//}
