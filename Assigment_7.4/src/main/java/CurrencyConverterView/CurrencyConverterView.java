package CurrencyConverterView;

import dao.CurrencyDao;
import entity.Currency;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import CurrencyConverterController.CurrencyConverterController;

import java.util.List;

public class CurrencyConverterView extends Application {
    private Stage stage;
    private TextField amountField;
    private TextField resultField;
    private ComboBox<Currency> sourceCurrencyBox;
    private ComboBox<Currency> targetCurrencyBox;
    private Button convertButton;
    private Button addCurrencyButton;

    public CurrencyConverterView() {
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        createUI();
        stage.show();
    }

    private void createUI() {
        VBox root = new VBox(10);
        amountField = new TextField();
        resultField = new TextField();
        resultField.setEditable(false);
        sourceCurrencyBox = new ComboBox<>();
        targetCurrencyBox = new ComboBox<>();
        convertButton = new Button("Convert");
        addCurrencyButton = new Button("Add Currency");

        CurrencyDao currencyDao = new CurrencyDao();
        List<Currency> currencies = currencyDao.getAllCurrencies();
        sourceCurrencyBox.getItems().addAll(currencies);
        targetCurrencyBox.getItems().addAll(currencies);

        root.getChildren().addAll(
                new Label("Amount:"), amountField,
                new Label("Source Currency:"), sourceCurrencyBox,
                new Label("Target Currency:"), targetCurrencyBox,
                convertButton, addCurrencyButton,
                new Label("Result:"), resultField
        );

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        new CurrencyConverterController(this);
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

    public Button getAddCurrencyButton() {
        return addCurrencyButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}