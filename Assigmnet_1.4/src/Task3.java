import java.util.Scanner;

public class Task3 {

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
//        int[] numbers = new int[]{1, 2, 3, 2, 1, 3, 4, 5};
//        int size = 8;


        int[] array = new int[size];
        boolean dupe = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] == numbers[i]) {
                    dupe = true;
                    break;
                }
            }
            if(!dupe) {
                array[i] = numbers[i];
            }
            dupe = false;
        }
        System.out.println("The array without duplicates: ");
        for (int j : array) {
            if(j != 0) {
                System.out.printf("%d ", j);
            }
        }
    }
}
