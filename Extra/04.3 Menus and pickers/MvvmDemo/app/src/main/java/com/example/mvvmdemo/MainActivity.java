package com.example.mvvmdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    //intent extra message
    public static final String EXTRA_TITLEs = "com.example.mvvmdemo.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTIONs = "com.example.mvvmdemo.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITYs = "com.example.mvvmdemo.EXTRA_PRIORITY";
    public static final String EXTRA_IDs = "com.example.mvvmdemo.EXTRA_ID";
    public static final String EXTRA_DATEs="com.example.mvvmdemo.EXTRA_DATE";
    public static final String EXTRA_TIMEs="com.example.mvvmdemo.EXTRA_TIME";



    public static final int ADD_NOTE_REQUEST = 1;
    public static final int EDIT_NOTE_REQUEST = 2;
    private NoteViewModel noteViewModel;
    NoteAdapter adapter;
    RecyclerView recyclerView;

    TextView noteViewDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create floating action button instance
        FloatingActionButton buttonAddNote = findViewById(R.id.btn_add_note);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditNoteActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);

            }
        });

        //reference to recycler view
        recyclerView = findViewById(R.id.recycler_view);
        //every recycler view need a layout manager,which takes care of displaying single item in order
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //after recycler view we create a note adapter
        //final NoteAdapter
        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);


        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                //noteViewModel make its instance and fetch the live data and observe the data.
                //if changes in data then the data will be updated.
                //since the list in adapter is empty we update adapter notes(List ) here.
                // adapter.setNotes(notes);
                adapter.submitList(notes);
                //  Toast.makeText(MainActivity.this,"helo world"+notes.get(0).getTitle(),Toast.LENGTH_LONG).show();


            }
        });
//add swaping functionality
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                if (ItemTouchHelper.LEFT == i) {
                    noteViewModel.delete(adapter.getNoteAt(viewHolder.getAdapterPosition()));
                    Toast.makeText(MainActivity.this, "NOTE DELETED", Toast.LENGTH_SHORT).show();
                } else if (ItemTouchHelper.RIGHT == i) {
                    Note note = adapter.getNoteAt(viewHolder.getAdapterPosition());
                    Intent intent = new Intent(MainActivity.this, AddEditNoteActivity.class);
                    intent.putExtra(AddEditNoteActivity.EXTRA_ID, note.getId());
                    intent.putExtra(AddEditNoteActivity.EXTRA_TITLE, note.getTitle());
                    intent.putExtra(AddEditNoteActivity.EXTRA_DESCRIPTION, note.getDescription());
                    intent.putExtra(AddEditNoteActivity.EXTRA_PRIORITY, note.getPriority());
                    startActivityForResult(intent, EDIT_NOTE_REQUEST);

                }

            }

            public static final float ALPHA_FULL = 1.0f;

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    final ColorDrawable background = new ColorDrawable(Color.GREEN);
                    final ColorDrawable backgroundRight = new ColorDrawable(Color.RED);


                    if (dX > 0) {
                        background.setBounds(0, viewHolder.itemView.getTop(), Math.round(dX), viewHolder.itemView.getBottom());
                        background.draw(c);
                        Drawable icon = ContextCompat.getDrawable(viewHolder.itemView.getContext(), R.drawable.ic_edit);
                        icon.setBounds(200, viewHolder.itemView.getTop(), 400, viewHolder.itemView.getBottom());
                        icon.draw(c);
                        // Fade out the view when it is swiped out of the parent
                        final float alpha = ALPHA_FULL - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                        viewHolder.itemView.setAlpha(alpha);
                        viewHolder.itemView.setTranslationX(dX);


                    } else {

                        backgroundRight.setBounds(Math.round(dX), viewHolder.itemView.getTop(), viewHolder.itemView.getRight(), viewHolder.itemView.getBottom());
                        backgroundRight.draw(c);
                        Drawable icon = ContextCompat.getDrawable(viewHolder.itemView.getContext(), R.drawable.ic_delete);
                        icon.setBounds(700, viewHolder.itemView.getTop(), 900, viewHolder.itemView.getBottom());
                        icon.draw(c);

                    }
                    // Fade out the view when it is swiped out of the parent
                    final float alpha = ALPHA_FULL - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                    viewHolder.itemView.setAlpha(alpha);
                    viewHolder.itemView.setTranslationX(dX);


                } else {

                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }


            }
        }).attachToRecyclerView(recyclerView);


        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickLIstener() {
            @Override
            public void onItemClick(Note note) {

                //create a bundle which will then be sent to the dialog
                Bundle bundle = new Bundle();
                bundle.putString(EXTRA_TITLEs, note.getTitle());
                bundle.putString(EXTRA_DESCRIPTIONs, note.getDescription());
                bundle.putInt(EXTRA_PRIORITYs, note.getPriority());
                bundle.putString(EXTRA_DATEs,note.getDate());
                bundle.putString(EXTRA_TIMEs,note.getTime());

                NoteDialog dialog = new NoteDialog();
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "Note dialog");


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("HELLO : ", "HELLO I AM HERE FIRST");
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {

            String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);
            String date = data.getStringExtra(AddEditNoteActivity.EXTRA_DATE);
            String time = data.getStringExtra(AddEditNoteActivity.EXTRA_TIME);


            //create a note object from the data fetched from add note activity
            Note note = new Note(title, description, priority,date,time);
            noteViewModel.insert(note);
            Toast.makeText(this, "NOTE SAVED SUCCESS", Toast.LENGTH_SHORT).show();
        } else if (requestCode == EDIT_NOTE_REQUEST && resultCode == RESULT_OK) {

            int id = data.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1);
            if (id == -1) {
                Toast.makeText(this, "note cant be updated", Toast.LENGTH_SHORT).show();
                return;

            }

            String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);
            String date = data.getStringExtra(AddEditNoteActivity.EXTRA_DATE);
            String time = data.getStringExtra(AddEditNoteActivity.EXTRA_TIME);



            Note note = new Note(title, description, priority,date,time);
            note.setId(id);
            noteViewModel.update(note);
            Toast.makeText(this, "NOTE UPDATED", Toast.LENGTH_SHORT).show();

        } else if (resultCode == RESULT_CANCELED) {
            recyclerView.setAdapter(adapter);
            Toast.makeText(this, "NOTE NOT SAVED", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.delete_all_notes:
                noteViewModel.deleteAllNotes();
                Toast.makeText(this, "ALL NOTES DELETED", Toast.LENGTH_SHORT).show();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }


    }
}
