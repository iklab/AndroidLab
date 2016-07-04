package com.multicampus.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ItemEditActivity extends AppCompatActivity {

    private EditText contentView;
    private Button btnSave;
    private Button btnCancel;
    private Button btnList;
    private CheckBox importantView;

    private int todoId = 0;
    private TodoItem todoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifecycle", "1. onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_edit);

        setView();
        setEvent();
    }

    private void setView(){
        contentView = (EditText)findViewById(R.id.content);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnList = (Button)findViewById(R.id.btnList);
        importantView = (CheckBox)findViewById(R.id.important);

        Intent intent = getIntent();
        String title = intent.getStringExtra(Intent.EXTRA_TITLE);
        String content = intent.getStringExtra(Intent.EXTRA_TEXT);

        Log.d(this.getClass().getSimpleName(), title + ", " + content);

        if(title == null || title.trim().length() == 0){
            title = "제목 없음";
        }
        if(content == null){
            content = "";
        }

        setTitle(title);
        contentView.setText(content);
    }

    private void setEvent(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
//                finish();

                Intent intent = new Intent(ItemEditActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(1000*2);
                finish();
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemEditActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
    }


    private TodoItem getTodoItem(){
        String title = getTitle().toString();
        String content = contentView.getText().toString();
        boolean important = importantView.isChecked();
        TodoItem item = new TodoItem(todoId, title, content, false, important);
        return item;
    }

    private void addItem(){
        TodoItem item = getTodoItem();

        DBHandler handler = DBHandler.open(this);
        handler.insert(item);
        handler.close();
    }


    @Override
    protected void onRestart() {
        Log.d("lifecycle", "1.5 onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.d("lifecycle", "2. onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifecycle", "3. onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("lifecycle", "4. onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("lifecycle", "5. onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifecycle", "6. onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("lifecycle", "4.5. onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("lifecycle", "2.5. onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }
}
