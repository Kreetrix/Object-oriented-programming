package Task2;

interface Vehicle {
    void start();
    void stop();
    void getInfo();
}

abstract class AbstractVehicle implements Vehicle {

    public AbstractVehicle() {
        this.start();
        this.stop();
        this.getInfo();
    }

    public void display() {
        System.out.println("Displaying Vehicle: ");
    }
}

class Car extends AbstractVehicle {

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
                Color: Red
                """);
    }

}

class Motorcycle extends AbstractVehicle {

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
                Color: Black
                """);
    }

}

class Bus extends AbstractVehicle {

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
                Capacity: 40 passengers
                """);
    }

}

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        Bus bus = new Bus();

        car.display();
        car.start();
        car.stop();
        car.getInfo();

        motorcycle.display();
        motorcycle.start();
        motorcycle.stop();
        motorcycle.getInfo();

        bus.display();
        bus.start();
        bus.stop();
        bus.getInfo();

    }
}