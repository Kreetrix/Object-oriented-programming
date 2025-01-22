import java.util.Scanner;

public class Task1 {

    static String[] firstNames = {"Leeroy", "Pepe", "Harambe", "Giga", "Sigma", "Skidibi"};
    static String[] lastNames = {"Jenkins", "Car", "NPC", "Chad", "Wojak", "Rizz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of names to generate: \n");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int nameIndex = (int) (Math.random() * firstNames.length);
            int lastNameIndex = (int) (Math.random() * lastNames.length);

            System.out.printf("%s %s\n", firstNames[nameIndex], lastNames[lastNameIndex]);
        }
        sc.close();
    }
}
