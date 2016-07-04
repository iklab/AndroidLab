package com.multicampus.androidlab.ch07;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.multicampus.androidlab.R;

public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch07_activity_custom_view);
        CircleView circle = (CircleView)findViewById(R.id.circle);

//        CircleView circle = new CircleView(this);
//        setContentView(circle);

        CircleClickListener listener1 = new CircleClickListener();
        circle.setOnClickListener(listener1);

        circle.setOnClickListener(this);

        circle.setOnClickListener(circle);

        View.OnClickListener listener2 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(CustomViewActivity.class.getSimpleName(), "2-4 익명 inner 클래스 사용");
            }
        };
        circle.setOnClickListener(listener2);

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(CustomViewActivity.class.getSimpleName(), "2-5 익명 inner 클래스 사용(임시 객체)");
            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.d(CustomViewActivity.class.getSimpleName(), "2-2. Activity에서 리스너 인터페이스 구현");
    }

    class CircleClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.d(CustomViewActivity.class.getSimpleName(), "2-1. 리스너 인터페이스 구현 클래스 정의");
        }
    }

}
