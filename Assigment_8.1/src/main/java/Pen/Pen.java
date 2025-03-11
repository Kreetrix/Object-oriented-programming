package Pen;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color currentColor;
    private Color nextColor;
    private boolean isCapped;

    public Pen() {
        this(Color.RED);
    }

    public Pen(Color color) {
        this.currentColor = color;
        this.nextColor = color;
        this.isCapped = true;
    }

    public void capOn() {
        this.isCapped = true;
    }

    public void capOff() {
        this.isCapped = false;
        this.currentColor = this.nextColor;
    }

    public void changeColor(Color newColor) {
        this.nextColor = newColor;
    }

    public String draw() {
        if (isCapped) {
            return "";
        } else {
            return "Drawing " + currentColor.toString();
        }
    }
}