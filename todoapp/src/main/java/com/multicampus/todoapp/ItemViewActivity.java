package com.multicampus.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ItemViewActivity extends AppCompatActivity {

    private TextView content;
    private Button btnEdit;
    private Button btnList;

    private TodoItem todoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        setView();
        setEvent();
    }

    private void setView(){
        content = (TextView)findViewById(R.id.content);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnList = (Button)findViewById(R.id.btnList);

        Intent intent = getIntent();
        todoItem = (TodoItem)intent.getSerializableExtra("item");

        setTitle(todoItem.getTitle());
        content.setText(todoItem.getContent());
    }

    private void setEvent(){
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemViewActivity.this, "수정 버튼 클릭", Toast.LENGTH_SHORT).show();
                Log.d(ItemViewActivity.class.getName(), "수정 버튼 클릭");
                Intent intent = new Intent(ItemViewActivity.this, ItemEditActivity.class);
                intent.putExtra(Intent.EXTRA_TITLE, todoItem.getTitle());
                intent.putExtra(Intent.EXTRA_TEXT, todoItem.getContent());
                startActivity(intent);
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemViewActivity.this, "목록 버튼 클릭", Toast.LENGTH_LONG).show();
                Log.e(ItemViewActivity.class.getName(), "목록 버튼 클릭");
                Intent intent = new Intent(ItemViewActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        menu.add(0, 0, 0, R.string.share);
//        menu.add(0, 1, 0, R.string.delete);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_view, menu);


        // false를 반환할 경우 메뉴를 화면에 보여주지 않는다.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.shareMenu:
                Log.d(this.getClass().getSimpleName(), "공유 메뉴 선택");
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
//                intent.setType("application/zip");
                intent.putExtra(Intent.EXTRA_TITLE, todoItem.getTitle());
                intent.putExtra(Intent.EXTRA_TEXT, todoItem.getContent());
                startActivity(Intent.createChooser(intent, "공유할 앱을 선택하세요."));
                break;
            case R.id.deleteMenu:
                Log.d(this.getClass().getSimpleName(), "삭제 메뉴 선택");
                break;
        }

        return true;
    }
}





