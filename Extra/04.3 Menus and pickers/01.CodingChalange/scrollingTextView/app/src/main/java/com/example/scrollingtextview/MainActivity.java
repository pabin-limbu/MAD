package com.example.scrollingtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView article_textView = findViewById(R.id.article);
        registerForContextMenu(article_textView);
    }



    // implementation to inflate menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // inflate menu in this activity
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context,menu);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_edit:
                displayToast("Edit choice clicked.");
                return true;
            case R.id.itm_Share:
                displayToast("Share choice clicked.");
                return true;
            case R.id.itm_delete:
                displayToast("Delete choice clicked.");
                return true;
            default:
                return super.onContextItemSelected(item);
        }

   }

   public void displayToast(String msg){
       Toast.makeText(getApplicationContext(), msg,
               Toast.LENGTH_SHORT).show();

   }
}
