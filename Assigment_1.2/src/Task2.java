import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first leg or a right triangle: ");
        double first = sc.nextDouble();

        System.out.println("Input second leg or a right triangle: ");
        double second = sc.nextDouble();

        double hypotenuse = Math.sqrt(Math.pow(first, 2) + Math.pow(second, 2));
        System.out.printf("Hypotenuse: %.2f", hypotenuse);
    }
}
