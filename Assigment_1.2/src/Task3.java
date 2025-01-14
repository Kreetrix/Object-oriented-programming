import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Weight (g): ");
        double weight = sc.nextDouble();

        final double luoti = weight / 13.28;
        final int naula = (int) luoti / 32;
        final int leiviska = naula / 20;

        System.out.printf("%.2f grams is %d leiviska, %d naula, and %.2f luoti", weight, leiviska, naula, luoti);
    }
}
