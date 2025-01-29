package Task2;

public class Car {
    protected double gasConsumption;
    private double speed;
    private double currentSpeed;
    private double gasolineLevel;
    private String typeName;

    public Car(String typeName, double speed) {
        this.gasConsumption = 2.0;
        this.speed = speed;
        currentSpeed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            currentSpeed += this.speed;
            gasolineLevel -= this.gasConsumption;
        }
        else currentSpeed = 0;
    }
    void decelerate(int amount) {
        if (amount > 0)
            currentSpeed = Math.max(0, currentSpeed - amount);
    }
    double getSpeed() {
        return currentSpeed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
}