package com.example.mvvmtodo;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {

    //intent extra message
    public static final String EXTRA_TITLE = "com.example.mvvmtodo.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.example.mvvmtodo.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.example.mvvmtodo.EXTRA_PRIORITY";
    public static final String EXTRA_ID = "com.example.mvvmtodo.EXTRA_ID";
    public static final String EXTRA_DATE="com.example.mvvmtodo.EXTRA_DATE";
    public static final String EXTRA_TIME="com.example.mvvmtodo.EXTRA_TIME";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private TextView editTextDate;
    private TextView editTextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //bind
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        editTextDate = findViewById(R.id.txtDate);
        editTextTime = findViewById(R.id.txtTime);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {

            setTitle("EDIT NOTE");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
             numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY,1));

        } else {
            setTitle("ADD NOTE");
        }
    }


    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();
        String date =editTextDate.getText().toString();
        String time =editTextTime.getText().toString();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(AddEditNoteActivity.this, "Please Insert Title and Description", Toast.LENGTH_SHORT).show();
            return;

        }

        //we need an intent to send data back to main activity
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);
        data.putExtra(EXTRA_DATE,date);
        data.putExtra(EXTRA_TIME,time);



        //for edit
        int id = getIntent().getIntExtra(EXTRA_ID,-1);
        if (id != -1){
            data.putExtra(EXTRA_ID,id);

        }
        setResult(RESULT_OK, data);
        finish();

    }

    //add our menu in the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    //handle click event in menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
            //   Log.d("HELLO : ", "HELLO I AM HERE");
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void showDatePicker(View view) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void showTimePicker(View view) {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getSupportFragmentManager(),"Time picker");
    }

    public void setTime(int hour,int minute){

editTextTime.setText(Integer.toString(hour)+":"+Integer.toString(minute));
    }

    public void setDate(int day,int month,int year){

        editTextDate.setText(Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
    }


}
