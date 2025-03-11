package dao;

import datasource.MariaDbConnection;

import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CurrencyDao {
    private EntityManager entityManager;

    public CurrencyDao() {
        this.entityManager = MariaDbConnection.getInstance();
    }

    public double getConversionRate(String abbreviation) {
        TypedQuery<Double> query = entityManager.createQuery(
                "SELECT c.conversionRate FROM Currency c WHERE c.abbreviation = :abbreviation", Double.class);
        query.setParameter("abbreviation", abbreviation);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return -1;
        }
    }

    public List<Currency> getAllCurrencies() {
        EntityManager entityManager = MariaDbConnection.getInstance();
        TypedQuery<Currency> query = entityManager.createQuery("SELECT c FROM Currency c", Currency.class);
        List<Currency> currencies = query.getResultList();
        System.out.println("Fetched currencies: " + currencies);
        return currencies;
    }

    public void addCurrency(Currency currency) {
        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
    }
}