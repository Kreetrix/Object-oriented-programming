import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        String binary = sc.nextLine();
        int decimal = 0;
        if (binary.matches("[0-9]+")) {
            binary = new StringBuilder(binary).reverse().toString();
            for (int i = 0; i < binary.length(); i++) {
                char bit = binary.charAt(i);
                decimal += (int) ((bit - '0') * Math.pow(2, i));

            }
            System.out.print(decimal);
        }
        else {
            System.out.print("Input only binary number");
        }
    }
}
