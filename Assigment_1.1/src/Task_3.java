import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        float average = (float) (first + second + third) / 3;

        int product = first * second * third;

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("The average of the numbers is " + (average));
        System.out.println("The product of the numbers is " + (product));

    }
}