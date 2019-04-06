package com.example.shopinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemListActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY="com.example.android.shoppingList.extra.reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
    }

    public void returnItemToMainActivity(View view) {
        String item=((Button)view).getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK, replyIntent);
        finish();

    }
}
