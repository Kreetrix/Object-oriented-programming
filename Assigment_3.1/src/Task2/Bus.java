package Task2;

public class Bus extends Car {
    private int maxPassengers;
    private int currentPassengers;

    public Bus(String typeName, double speed) {
        super(typeName, speed);
        this.gasConsumption = 8.0;
    }

    void passengerEnter(int amount){
        if(currentPassengers + amount <= maxPassengers){
            currentPassengers += amount;
        }
    }

    void passengerExit(int amount){
        currentPassengers -= amount;
    }
}
