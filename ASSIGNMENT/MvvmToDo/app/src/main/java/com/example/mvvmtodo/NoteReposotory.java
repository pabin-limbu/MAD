package com.example.mvvmtodo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;



public class NoteReposotory {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;


    //application is sub class of context. we can use context to create our database instance.

    public NoteReposotory(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }


    //below all method are the API that reposotory exposes to the outside.

    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);

    }

    public void update(Note note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);

    }

    public void deleteAllnotes() {
        new DeleteAllNoteAsyncTask(noteDao).execute();

    }

    public LiveData<List<Note>> getAllNotes() {

        return allNotes;
    }


    //create a assynchronous class to prevent application freeze
    //room does not allow database operation on the main thread

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    //for update
    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    //for delete
    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    //for fetch all
    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {

        private NoteDao noteDao;

        private DeleteAllNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;

        }

        @Override
        protected Void doInBackground(Void... Voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }


}
