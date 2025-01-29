package Task3;

import java.util.ArrayList;

public class ShapeCalculator {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(2.5, 8.0));
        shapes.add(new Triangle(10.0, 15.0));

        for(Shape shape : shapes) {
            shape.calculateArea();
            System.out.println("Area of " + shape.getClass().getSimpleName() + " is " + shape.calculateArea() );
        }
    }
}
