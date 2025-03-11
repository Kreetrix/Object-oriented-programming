package CurrencyConverterController;

import dao.CurrencyDao;
import CurrencyConverterView.CurrencyConverterView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import entity.Currency;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

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
        System.out.println("Button pressed");
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

    private void addDefaultCurrencies() {
        Currency[] defaultCurrencies = {
                new Currency("USD", "US Dollar", 1.0),
                new Currency("EUR", "Euro", 1.09),
                new Currency("GBP", "British Pound", 1.29),
                new Currency("JPY", "Japanese Yen", 0.0068),
                new Currency("CAD", "Canadian Dollar", 0.74)
        };

        try {
            for (Currency currency : defaultCurrencies) {
                currencyDao.addCurrency(currency);
            }
        } catch (Exception e) {
            System.out.println("No currencies added");
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