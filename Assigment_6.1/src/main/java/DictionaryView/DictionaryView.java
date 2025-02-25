package DictionaryView;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import DictionaryController.DictionaryController;

public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new DictionaryController();

        Label wordLabel = new Label("Enter a word:");
        TextField wordField = new TextField();
        Button searchButton = new Button("Search");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.getChildren().addAll(wordLabel, wordField, searchButton, resultArea);

        searchButton.setOnAction(e -> {
            String word = wordField.getText().trim();
            if (word.isEmpty()) {
                resultArea.setText("Please enter a word.");
            } else {
                String meaning = controller.searchWord(word);
                resultArea.setText(meaning);
            }
        });

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Virtual Dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}