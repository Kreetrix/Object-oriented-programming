import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input temperature in Fahrenheit:");
        double tempF = scanner.nextDouble();

        double tempC = (tempF - 32) * 5 / 9;

        System.out.printf("Temperature in Celsius: %.2f", tempC);
    }
}
