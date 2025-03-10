package Task1;

import java.util.Arrays;

public class Mean {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        double mean = Arrays.stream(numbers)
            .average()
            .orElse(Double.NaN);
        System.out.println("Mean: " + mean);
    }
}