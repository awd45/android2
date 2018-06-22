package com.example.smart_01.intentreex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idInput, passwordInput;
    Intent intent;
    String id, password;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id찾기
        idInput = (EditText)findViewById(R.id.idInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        loginButton = (Button)findViewById(R.id.loginButton);

        //버튼에 기능 넣기
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = idInput.getText().toString();
                password = passwordInput.getText().toString();

                AppData.password = password; // 패스워드를 두 액티비티가 공유



                // 인텐트의 인트스턴스화
                intent = new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("password", password);

                // 결과값 받을 경우 보내기만 할 경우 startActivity(intent)
                startActivityForResult(intent,101);
           }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null){
            if (requestCode == 101){
                String type = data.getStringExtra("type");
                Toast.makeText(this,"전달받은 데이터 : " + type, Toast.LENGTH_LONG).show();
            }
        }
    }
}
