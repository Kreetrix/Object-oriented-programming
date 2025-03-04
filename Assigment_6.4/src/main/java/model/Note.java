package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Note {
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty content = new SimpleStringProperty();

    public Note(String title, String content) {
        this.title.set(title);
        this.content.set(content);
    }

    public final String getTitle() {
        return title.get();
    }

    public final void setTitle(String title) {
        this.title.set(title);
    }

    public final String getContent() {
        return content.get();
    }

    public final void setContent(String content) {
        this.content.set(content);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}