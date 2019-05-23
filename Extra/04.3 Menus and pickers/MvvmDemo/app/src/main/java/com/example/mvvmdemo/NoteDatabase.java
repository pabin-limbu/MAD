package com.example.mvvmdemo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {Note.class}, version = 2)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    //synchronize means only one thread at a time can access this method.
    public static synchronized NoteDatabase getInstance(Context context) {

        if (instance == null) {
//since note database is an abstract method so creating obj is not allowed so we call database builder to create instance.

            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;

    }

    private static  RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDbAsyncTask(instance).execute();
        }
    };


    private static class populateDbAsyncTask extends AsyncTask<Void,Void,Void>{
private NoteDao notedao;

private populateDbAsyncTask(NoteDatabase db){
notedao= db.noteDao();

}
        @Override
        protected Void doInBackground(Void... voids) {
    notedao.insert(new Note("Title 1","description 1",1,"11/02/1995","13:25"));
    notedao.insert(new Note("Title 2","description 2",2,"11/02/1995","13:25"));
    notedao.insert(new Note("Title 3","description 3",3,"11/02/1995","13:25"));
            return null;
        }
    }

}
