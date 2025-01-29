package Task1;

public class CarDriver {

    public static void main(String[] args) {
        Car myCar;
        SportsCar mySportsCar;

        myCar = new Car("Toyota Corolla", 30);
        mySportsCar = new SportsCar("Toyota Toyota", 50);
        myCar.fillTank();
        mySportsCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(mySportsCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        for (int i = 0; i < 6; i++) {
            mySportsCar.accelerate();
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + " km/h");
        }

        while (mySportsCar.getSpeed() > 0) {
            mySportsCar.decelerate(15);
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + " km/h");
        }

    }
}