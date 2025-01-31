package Task1;

interface Vehicle {
    void start();
    void stop();
    void getInfo();
}

class Car implements Vehicle {

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
                Type: Car
                Fuel: Petrol
                Color: Red
                """);
    }
}

class Motorcycle implements Vehicle {

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

class Bus implements Vehicle {

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

        car.start();
        car.stop();
        car.getInfo();

        motorcycle.start();
        motorcycle.stop();
        motorcycle.getInfo();

        bus.start();
        bus.stop();
        bus.getInfo();
    }
}