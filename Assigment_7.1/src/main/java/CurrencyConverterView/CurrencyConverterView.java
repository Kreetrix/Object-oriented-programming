package CurrencyConverterView;

import Currency.Currency;
import CurrencyConverterController.CurrencyConverterController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyConverterView extends Application {
    private Stage stage;
    private TextField amountField;
    private TextField resultField;
    private ComboBox<Currency> sourceCurrencyBox;
    private ComboBox<Currency> targetCurrencyBox;
    private Button convertButton;

    public CurrencyConverterView(Stage stage) {
        this.stage = stage;
        createUI();
    }

    private void createUI() {
        Label titleLabel = new Label("Currency Converter");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        Label amountLabel = new Label("Enter amount:");
        amountField = new TextField();
        amountField.setPromptText("Amount");

        Label sourceLabel = new Label("From:");
        sourceCurrencyBox = new ComboBox<>();

        Label targetLabel = new Label("To:");
        targetCurrencyBox = new ComboBox<>();

        convertButton = new Button("Convert");

        Label resultLabel = new Label("Result:");
        resultField = new TextField();
        resultField.setEditable(false);

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                titleLabel,
                amountLabel, amountField,
                sourceLabel, sourceCurrencyBox,
                targetLabel, targetCurrencyBox,
                convertButton,
                resultLabel, resultField
        );

        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
    }

    public TextField getAmountField() {
        return amountField;
    }

    public TextField getResultField() {
        return resultField;
    }

    public ComboBox<Currency> getSourceCurrencyBox() {
        return sourceCurrencyBox;
    }

    public ComboBox<Currency> getTargetCurrencyBox() {
        return targetCurrencyBox;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public void show() {
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        CurrencyConverterView view = new CurrencyConverterView(primaryStage);
        new CurrencyConverterController(view);
        view.show();
    }
}