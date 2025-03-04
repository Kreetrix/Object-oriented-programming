package CurrencyConverterView;

import entity.Currency;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import CurrencyConverterController.CurrencyConverterController;

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