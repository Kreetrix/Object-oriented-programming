package CurrencyConverterController;

import dao.CurrencyDao;
import CurrencyConverterView.CurrencyConverterView;
import dao.TransactionDao;
import entity.Transaction;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import entity.Currency;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        System.out.println("Get convert button" + convertButton);

        convertButton.setOnAction(e -> convert());

        Button addCurrencyButton = view.getAddCurrencyButton();
        addCurrencyButton.setOnAction(e -> openAddCurrencyWindow());
    }

    private void convert() {
        try {
            double amount = Double.parseDouble(view.getAmountField().getText());
            Currency sourceCurrency = view.getSourceCurrencyBox().getValue();
            Currency targetCurrency = view.getTargetCurrencyBox().getValue();

            if (sourceCurrency == null || targetCurrency == null) {
                view.getResultField().setText("Error: Please select source and target currencies.");
                return;
            }

            double sourceRate = currencyDao.getConversionRate(sourceCurrency.getAbbreviation());
            double targetRate = currencyDao.getConversionRate(targetCurrency.getAbbreviation());

            if (sourceRate == -1 || targetRate == -1) {
                view.getResultField().setText("Error: Unable to fetch exchange rates.");
                return;
            }

            double conversionRate = targetRate / sourceRate;
            double result = amount * conversionRate;
            view.getResultField().setText(String.format("%.2f", result));

            Transaction transaction = new Transaction(amount, sourceCurrency, targetCurrency);
            TransactionDao transactionDao = new TransactionDao();
            transactionDao.saveTransaction(transaction);
        } catch (NumberFormatException e) {
            view.getResultField().setText("Invalid input");
        }
    }

    private void openAddCurrencyWindow() {
        Stage newStage = new Stage();
        VBox root = new VBox(10);
        TextField abbreviationField = new TextField();
        TextField nameField = new TextField();
        TextField rateField = new TextField();
        Button saveButton = new Button("Save");

        saveButton.setOnAction(e -> {
            try {
                String abbreviation = abbreviationField.getText();
                String name = nameField.getText();
                double rate = Double.parseDouble(rateField.getText());

                Currency newCurrency = new Currency(abbreviation, name, rate);
                currencyDao.addCurrency(newCurrency);

                view.getSourceCurrencyBox().getItems().add(newCurrency);
                view.getTargetCurrencyBox().getItems().add(newCurrency);

                newStage.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input for conversion rate.");
                alert.showAndWait();
            }
        });

        root.getChildren().addAll(
                new Label("Abbreviation:"), abbreviationField,
                new Label("Name:"), nameField,
                new Label("Conversion Rate:"), rateField,
                saveButton
        );

        Scene scene = new Scene(root, 300, 200);
        newStage.setScene(scene);
        newStage.showAndWait();
    }
}