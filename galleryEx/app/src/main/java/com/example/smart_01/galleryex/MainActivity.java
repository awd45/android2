package com.example.smart_01.galleryex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 실습");

        // id 찾기
        gallery = (Gallery)findViewById(R.id.gallery1);
        MyGalleryAdapter galadapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galadapter);
    }
}
