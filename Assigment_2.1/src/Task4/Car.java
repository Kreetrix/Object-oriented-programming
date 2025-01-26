package Task4;

public class Car {

    private double speed;
    private double gasolineLevel;
    private boolean cruise;
    private double targetSpeed;
    private String typeName;

    public Car(String typeName, double speed) {
        gasolineLevel = 0;
        this.speed = speed;
        this.typeName = typeName;
    }

    public boolean turnCruise(double targetSpeed) {
        if(targetSpeed <= 120 && targetSpeed >= 10) {
            this.targetSpeed = targetSpeed;
            this.cruise = true;
            return true;
        }
        else{
            System.out.println("Invalid speed, turning off cruise control");
        }
        return false;
    }

    public double getTargetSpeed() {
        return this.targetSpeed;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 1.0;
        }
        else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if(cruise) {
                while (speed >= targetSpeed) {
                    speed -= 1.0;
                }
            }
            else if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
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