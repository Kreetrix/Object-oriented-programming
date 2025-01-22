import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            numbers[i] = sc.nextInt();
        }
        //test
//        int[] numbers = new int[]{-2, 1, -3, 4, -1, 2, 1, -5};
//        int size = 8;


        int result = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < size; i++) {
            int sum = 0;
            for(int j = i; j < size; j++){
                sum += numbers[j];

                if (sum > result) {
                    result = sum;
                    start = i + 1;
                    end = j + 1;
                }

            }

        }
        System.out.printf("Maximum sum: %d\n", result);
        System.out.printf("Integers: %d-%d", start, end);
    }
}
