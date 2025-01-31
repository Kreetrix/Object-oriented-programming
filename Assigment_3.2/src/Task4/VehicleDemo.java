package Task4;

interface Vehicle {
    void start();
    void stop();
    void getInfo();
    double calculateFuelEfficiency();
}

interface ElectricVehicle{
    void charge();
}

abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected double fuelEfficiency;
    protected double fuelUsed;
    private final int distance;

    public AbstractVehicle(double LiterPerKilometer) {
        this.fuelUsed = LiterPerKilometer;
        this.distance = 500;
    }

    public double calculateFuelEfficiency() {
        return this.fuelEfficiency = this.distance / this.fuelUsed;
    }

    public void display() {
        System.out.println("Displaying Vehicle: ");
    }
}

class Car extends AbstractVehicle {

    public Car(double fuelUsed) {
        super(fuelUsed);
    }

    @Override
    public void start() {
        System.out.println("Car start");
    }

    @Override
    public void stop() {
        System.out.println("Car stop");
    }

    @Override
    public void getInfo() {
        System.out.println("""
                Car info:
                Type: Hybrid Car
                Fuel: Petrol
                Color: Red""");
    }

    @Override
    public void charge() {
        System.out.println("Possible to charge\n");
    }
}

class Motorcycle extends AbstractVehicle {

    public Motorcycle(double fuelUsed) {
        super(fuelUsed);
    }

    @Override
    public void start() {
        System.out.println("Motorcycle start");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stop");
    }

    @Override
    public void getInfo() {
        System.out.println("""
                Motorcycle info:
                Type: Motorcycle
                Fuel: Gasoline
                Color: Black""");
    }

    @Override
    public void charge() {
        System.out.println("Not possible to charge\n");
    }
}

class Bus extends AbstractVehicle {

    public Bus(double fuelUsed) {
        super(fuelUsed);
    }

    @Override
    public void start() {
        System.out.println("Bus start");
    }

    @Override
    public void stop() {
        System.out.println("Bus stop");
    }

    @Override
    public void getInfo() {
        System.out.println("""
                Bus info:
                Type: Bus
                Fuel: Diesel
                Capacity: 40 passengers""");
    }

    @Override
    public void charge() {
        System.out.println("Not possible to charge\n");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car(15);
        Motorcycle motorcycle = new Motorcycle(5);
        Bus bus = new Bus(30);

        car.display();
        car.start();
        car.stop();
        car.getInfo();
        car.charge();
        System.out.printf("Fuel efficiency -> %.2f\n", car.calculateFuelEfficiency());

        motorcycle.display();
        motorcycle.start();
        motorcycle.stop();
        motorcycle.getInfo();
        motorcycle.charge();
        System.out.printf("Fuel efficiency -> %.2f\n", motorcycle.calculateFuelEfficiency());

        bus.display();
        bus.start();
        bus.stop();
        bus.getInfo();
        bus.charge();
        System.out.printf("Fuel efficiency -> %.2f\n", bus.calculateFuelEfficiency());

    }
}