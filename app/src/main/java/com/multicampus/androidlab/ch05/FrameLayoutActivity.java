package com.multicampus.androidlab.ch05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.multicampus.androidlab.R;

public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch05_activity_frame_layout);

        Button pushButton = (Button)findViewById(R.id.btn);
        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View img = findViewById(R.id.korando);
                if(img.getVisibility() == View.VISIBLE){
                    img.setVisibility(View.INVISIBLE);
                }else{
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
