package Task4;

import java.util.Scanner;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;
        Scanner input = new Scanner(System.in);

        myCar = new Car("Toyota Corolla", 50);
        myCar.fillTank();

        System.out.println("Turn on cruise control? (y/n)");
        String answer = input.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Set cruise control target speed: ");
            double speed = input.nextDouble();
            boolean status = myCar.turnCruise(speed);
            if (status) {
                double currentSpeed;
                while (true) {
                    currentSpeed = myCar.getSpeed();
                    if(currentSpeed == speed) {
                        return;
                    }
                    else if (currentSpeed < speed) {
                        myCar.accelerate();
                        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
                    }
                    else if (currentSpeed > speed) {
                        myCar.decelerate(0); //no need for manual input, cruise control ain't that stupid (I hope)
                        System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
                    }
                }
            }
        }
    }
}