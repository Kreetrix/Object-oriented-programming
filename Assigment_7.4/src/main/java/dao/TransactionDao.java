package dao;

import datasource.MariaDbConnection;
import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    private EntityManager entityManager;

    public TransactionDao() {
        this.entityManager = MariaDbConnection.getInstance();
    }

    public void saveTransaction(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }
}