package com.example.smart_01.gridviewex;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridAdapter extends BaseAdapter {
    // 변수 선언
    Context context;
    // 배열 선언
    Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08};

    //배열추가
    String[] posterTitle = { "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","왤컴투동막골"};

    // context가 있는 생성자
    public  MyGridAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {// 전체 갯수
        return posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1> 이미지뷰를 생성한 후 값 직접 보여줌
        ImageView imageView= new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(200,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        // 2> 기능 부여
        final  int pos= position;
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                View dialogView = (View)View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle(posterTitle[pos]);
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        // 3> 결과값 리턴

        return imageView;
    }
}
