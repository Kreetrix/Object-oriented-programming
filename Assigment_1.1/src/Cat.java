public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Whiskers");
        for (int i = 0; i < 4; i++) {
            if (i == 2){
                cat.name = "Rex";
            }
            else cat.name = "Whiskers";
            cat.meow();
        }
    }
}