# Calculator Program

This program implements a simple calculator that can sum positive integers. It follows the Model-View-Controller (MVC) pattern, where the `Calculator` class acts as the model.

## Calculator Class

```java
public class Calculator {
    private int value;

    public Calculator() {
        this.value = 0;
    }

    public void reset() {
        this.value = 0;
    }

    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        this.value += number;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.add(5);
            calculator.add(10);
            calculator.add(3);
            System.out.println("Current value: " + calculator.getValue()); // Output: 18
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}