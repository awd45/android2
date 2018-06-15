package com.example.smart_01.graphicex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import static android.graphics.drawable.GradientDrawable.RECTANGLE;

public class MainActivity extends AppCompatActivity {

    final static int LINE=1, CIRCLE=2, RECTANGLE=3, PATH=4; // 도형을 상수로 지정
    static  int curshape=LINE; // 선택한 도형
    static int curColor=Color.RED;
    static int curWidth=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");

    }

    // menu 만들기


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선");
        menu.add(0,2,0,"원");
        menu.add(0,3,0,"사각형");
        menu.add(0,9,0,"PATH");

        SubMenu sMenu = menu.addSubMenu("색상변경");
        sMenu.add(0,4,0,"빨강");
        sMenu.add(0,5,0,"파랑");
        sMenu.add(0,6,0,"초록");

        SubMenu sMenu1 = menu.addSubMenu("선굵기 변경");
        sMenu1.add(0,7,0,"5");
        sMenu1.add(0,8,0,"10");




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1: curshape=LINE; // 선
                return true;
            case 2: curshape=CIRCLE; // 원
                return true;
            case 3: curshape=RECTANGLE; // 사각형
                return true;
            case 4:
                curColor = Color.RED;
                return true;
            case 5:
                curColor = Color.BLUE;
                return true;
            case 6:
                curColor = Color.GREEN;
                return true;

            case 7:
                curWidth = 5;
                return true;

            case 8:
                curWidth = 500;
                return true;

            case 9:
                curshape = PATH;
                return true;

        }

        return super.onOptionsItemSelected(item);
//       혹은 return false;
    }

    //  커스텀 뷰 생성 ==> 캔버스 공간 만들기
    private static class MyGraphicView extends View {
        // 전역 변수
        int startx = -1, starty=-1, stopx=-1, stopy=-1;
        public MyGraphicView(Context context) {
            super(context);
        }

        // 이벤트에 따라 좌표 계산
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN : // 눌렀을때
                    startx = (int) event.getX(); // x좌표
                    starty = (int) event.getY(); // y좌표 == > 시작지점
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopx = (int)event.getX(); // x좌표
                    stopy = (int)event.getY(); // y좌표 ==> 끝나는 지점
                    this.invalidate(); // 움직임 취소 ==> 좌표 체크 기능 취소
                    break;
            }

            return true;
        }

        // onDraw() 메서드
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(curWidth);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);

            //paint.setStyle(Paint.style.fil)

            switch (curshape){
                case LINE: canvas.drawLine(startx, starty, stopx, stopy, paint);
                break;
                case CIRCLE:
                    int radius = (int)Math.sqrt(Math.pow(stopx-startx,2) + Math.pow(stopy-starty,2));
                    // Math.pow(x,2) ==> x의 2승
                    // Math.sqrt : 루트
                    canvas.drawCircle(startx, starty, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(startx, starty, stopx, stopy);
                            canvas.drawRect(rect, paint);
                    break;
                    //new RecF : 모서리가 둥근 사각형
                    //canvas.drawRoundRect()
                
                case PATH :
                    Path path1 = new Path();
                    path1.moveTo(startx,starty); //시작지점
                    path1.lineTo(startx + 50, starty + 50);// 끝지점
                    path1.lineTo(startx + 100, starty);
                    path1.lineTo(startx + 150, starty + 50);
                    path1.lineTo(startx + 200, starty);
                    canvas.drawPath(path1, paint);

            }
        }





    }




}
