import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A: ");
        double A = sc.nextDouble();
        System.out.println("Enter B: ");
        double B = sc.nextDouble();
        System.out.println("Enter C: ");
        double C = sc.nextDouble();

        double equation  = Math.pow(B, 2) - 4*A*C;

        if (equation > 0){
            double root1 = (-B + Math.sqrt(equation)) / (2 * A);
            double root2 = (-B - Math.sqrt(equation)) / (2 * A);
            System.out.printf("Root 1 = %.2f \nRoot 2 = %.2f", root1, root2);
        }
        else if (equation == 0){
            double root = -B / (2 * A);
            System.out.println(root);
        }
        else {
            System.out.println("No real roots");
        }

    }
}
