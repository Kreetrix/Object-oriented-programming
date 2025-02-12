package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class Worker extends Thread {
    private int[] array;
    private int sum;


    Worker(int[] array) {
        this.array = array;
        this.sum = 0;
    }

    public void run() {
        for (int arr : array) {
            sum += arr;
            Thread.yield();
        }
    }

    public int getSum() {
        return sum;
    }
}



public class Main {
    private static final int[] array = IntStream.generate(() ->
        new Random()
            .nextInt(100))
            .limit(100000)
            .toArray();

    public static void execute(int cores){

        ArrayList<Worker> worker = new ArrayList<>();
        double dy = (double) array.length /cores;
        System.out.println(dy);
        for (int i = 0; i < cores; i++) {

            int slicestart = (int)Math.round(i*dy);
            int sliceend = array.length;
            if (i < cores-1) {
                sliceend = (int) Math.round((i + 1) * dy);
                System.out.println(slicestart + " " + sliceend);
            }

            worker.add(new Worker(Arrays.copyOfRange(array, slicestart, sliceend)));
        }

        for(Worker w : worker){
            w.start();
        }

        int sum = 0;
        for(Worker w : worker){
            try{
                w.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sum += w.getSum();
        }
        System.out.println("Total sum is -> " + sum);
    }

    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();
        execute(cores);
    }
}