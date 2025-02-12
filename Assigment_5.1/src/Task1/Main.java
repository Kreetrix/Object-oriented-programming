package Task1;

class OddThread implements Runnable {
    private int range;
    private int count;


    OddThread(int range) {
        this.range = range;
        this.count = 1;
    }

    public void run() {
        while(this.count <= this.range) {
            if(this.count % 2 == 1) {
                System.out.println("Odd Thread -> " + this.count);
            }
            this.count++;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        int count = 1;
        int range = 20;
        Runnable writer = new OddThread(range);
        Thread t = new Thread(writer);

        t.start();
        while(count <= range) {
            if(count % 2 == 0) {
                System.out.println("Even Thread -> " + count);
            }
            count++;
        }
        t.interrupt();
        System.out.println("Printing complete.");
    }
}