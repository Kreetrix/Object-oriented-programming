package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notebook {
    private final ObservableList<Note> notes = FXCollections.observableArrayList();

    public Notebook() {
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(Note note) {
        notes.remove(note);
    }


    public ObservableList<Note> getNotes() {
        return notes;
    }

}