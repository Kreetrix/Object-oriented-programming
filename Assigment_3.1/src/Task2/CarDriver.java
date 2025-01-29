package Task2;

public class CarDriver {

    public static void main(String[] args) {
        Car myCar;
        Bus myBus;

        myCar = new Car("Toyota Corolla", 30);
        myBus = new Bus("Toyota Toyota", 50);
        myCar.fillTank();
        myBus.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        for (int i = 0; i < 6; i++) {
            myBus.accelerate();
            System.out.println(myBus.getTypeName() + ": speed is " + myBus.getSpeed() + " km/h");
        }

        while (myBus.getSpeed() > 0) {
            myBus.decelerate(15);
            System.out.println(myBus.getTypeName() + ": speed is " + myBus.getSpeed() + " km/h");
        }
    }
}