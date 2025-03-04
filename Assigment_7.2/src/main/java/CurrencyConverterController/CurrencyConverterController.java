package CurrencyConverterController;

import dao.CurrencyDao;
import CurrencyConverterView.CurrencyConverterView;
import javafx.scene.control.Button;

public class CurrencyConverterController {
    private CurrencyConverterView view;
    private CurrencyDao currencyDao;

    public CurrencyConverterController(CurrencyConverterView view) {
        this.view = view;
        this.currencyDao = new CurrencyDao();
        initialize();
    }

    private void initialize() {
        Button convertButton = view.getConvertButton();
        convertButton.setOnAction(e -> convert());
    }

    private void convert() {
        try {
            double amount = Double.parseDouble(view.getAmountField().getText());
            String sourceAbbreviation = view.getSourceCurrencyBox().getValue().getAbbreviation();
            String targetAbbreviation = view.getTargetCurrencyBox().getValue().getAbbreviation();

            double sourceRate = currencyDao.getConversionRate(sourceAbbreviation);
            double targetRate = currencyDao.getConversionRate(targetAbbreviation);

            if (sourceRate == -1 || targetRate == -1) {
                view.getResultField().setText("Error: Unable to fetch exchange rates.");
                return;
            }

            double conversionRate = targetRate / sourceRate;
            double result = amount * conversionRate;

            view.getResultField().setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            view.getResultField().setText("Invalid input");
        }
    }
}