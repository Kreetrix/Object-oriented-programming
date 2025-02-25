package CurrencyConverterController;

import Currency.Currency;

import javafx.scene.control.Button;
import CurrencyConverterView.CurrencyConverterView;

public class CurrencyConverterController {
    private CurrencyConverterView view;
    private Currency[] currencies = {
            new Currency("USD", "US Dollar", 1.0),
            new Currency("EUR", "Euro", 0.85),
    };

    public CurrencyConverterController(CurrencyConverterView view) {
        this.view = view;
        initialize();
    }

    private void initialize() {
        view.getSourceCurrencyBox().getItems().addAll(currencies);
        view.getTargetCurrencyBox().getItems().addAll(currencies);
        view.getSourceCurrencyBox().getSelectionModel().selectFirst();
        view.getTargetCurrencyBox().getSelectionModel().selectFirst();

        Button convertButton = view.getConvertButton();
        convertButton.setOnAction(e -> convert());
    }

    private void convert() {
        try {
            double amount = Double.parseDouble(view.getAmountField().getText());
            Currency source = view.getSourceCurrencyBox().getValue();
            Currency target = view.getTargetCurrencyBox().getValue();

            double conversionRate = target.getConversionRate() / source.getConversionRate();
            double result = amount * conversionRate;

            view.getResultField().setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            view.getResultField().setText("Invalid input");
        }
    }
}
