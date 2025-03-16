package Task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        System.out.println("Original list: " + numbers);

        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After filtering even numbers: " + numbers);

        numbers.replaceAll(n -> n * 2);
        System.out.println("After doubling odd numbers: " + numbers);

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers: " + sum);
    }
}