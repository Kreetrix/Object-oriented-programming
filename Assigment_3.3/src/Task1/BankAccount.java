package Task1;

public class BankAccount {
    static int totalAccounts = 0;
    int accountNumber;
    double balance;

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
        }
        else {
            System.out.println("U broke");
        }
    }

    int getAccountNumber() {
        return this.accountNumber;
    }

    double getBalance() {
        return this.balance;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
