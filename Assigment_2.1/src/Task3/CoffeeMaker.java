package Task3;

public class CoffeeMaker {

    private int amount;
    private boolean status;
    private String coffeeType;

    public CoffeeMaker(int amount) {
        this.status = false;
        this.amount = amount;
    }

    public interface CoffeeType {
        String NORMAL = "Normal";
        String ESPRESSO = "Espresso";
    }

    void changeAmount(int amount) {
        if (amount >= 10 && amount <= 80 && this.status) {
            this.amount = amount;
        }
    }

    int currentAmount() {
        return this.amount;
    }

    String currentType() {
        return this.coffeeType.toString();
    }

    void changeType(String type) {
        if(status) {
            this.coffeeType = type;
        }
    }

    void switchStatus() {
        this.status = !this.status;
    }

    boolean getStatus() {
        return this.status;
    }

}
