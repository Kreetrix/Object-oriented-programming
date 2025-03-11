package dao;

import datasource.MariaDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {

    public double getConversionRate(String abbreviation) {
        String query = "SELECT conversion_rate FROM currencies WHERE abbreviation = ?";
        try (Connection connection = MariaDbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, abbreviation);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("conversion_rate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Indicates an error or no result found
    }
}