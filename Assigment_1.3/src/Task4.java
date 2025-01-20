import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int points = 0;
        while (points != 10){
            for (int i = 0; i < 10; i++) {
                int number1 = (int) (Math.random() * 10) + 1;
                int number2 = (int) (Math.random() * 10) + 1;
                int solution = number1 * number2;

                System.out.printf("What is %d multiplied by %d?\n", number1, number2);
                int answer = sc.nextInt();
                if (answer == solution) {
                    System.out.println("True");
                    points++;
                }
                else {
                    System.out.println("False");
                }
            }
            if(points == 10) {
                System.out.println("You mastered multiplications");
            }
            else {
                points = 0;
                System.out.println("Try again");
            }
        }
    }
}
