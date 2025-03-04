package controller;

import model.Note;
import model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<Note> noteListView;

    private Notebook notebook;
    private Note currentNote;

    public NoteController() {
        // Default constructor
    }

    @FXML
    private void initialize() {
        notebook = new Notebook();

        deleteButton.setDisable(true);

        noteListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        // Display the selected note
                        displayNote(newValue);
                        deleteButton.setDisable(false);
                    } else {
                        clearFields();
                        deleteButton.setDisable(true);
                    }
                }
        );

        noteListView.setItems(notebook.getNotes());
    }

    @FXML
    private void handleAddNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if (title.isEmpty()) {
            return;
        }

        if (currentNote != null && noteListView.getSelectionModel().getSelectedItem() == currentNote) {
            currentNote.setTitle(title);
            currentNote.setContent(content);

            int selectedIndex = noteListView.getSelectionModel().getSelectedIndex();
            noteListView.getItems().set(selectedIndex, currentNote);
            noteListView.getSelectionModel().select(selectedIndex);
        } else {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            noteListView.getSelectionModel().select(newNote);
        }

        currentNote = null;

        clearFields();

        noteListView.refresh();
    }

    @FXML
    private void handleDeleteNote() {
        Note selectedNote = noteListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            notebook.removeNote(selectedNote);
            clearFields();
            currentNote = null;
        }
    }

    @FXML
    private void handleClearSelection() {
        noteListView.getSelectionModel().clearSelection();

        clearFields();

        currentNote = null;

        deleteButton.setDisable(true);
    }

    private void displayNote(Note note) {
        currentNote = note;
        titleField.setText(note.getTitle());
        contentArea.setText(note.getContent());
    }

    private void clearFields() {
        titleField.clear();
        contentArea.clear();
    }
}