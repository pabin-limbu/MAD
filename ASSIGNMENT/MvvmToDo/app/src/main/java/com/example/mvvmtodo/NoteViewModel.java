package com.example.mvvmtodo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;


//android view model is the sub class of view model
public class NoteViewModel extends AndroidViewModel {

    private NoteReposotory repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteReposotory(application);
        allNotes = repository.getAllNotes();
    }


    public void insert(Note note) {

        repository.insert(note);
    }

    public void update(Note note) {

        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public void deleteAllNotes() {
        repository.deleteAllnotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
