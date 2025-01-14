
public class Task_2 {

    public static void main(String[] args) {
        String star = "*";
        int space = 5;
        for (int i = 0; i < 4; i++) {
            String formatted = String.format("%" + space + "s", star);
            System.out.println(formatted);
            star = star + "**";
            space++;
        }
    }
}