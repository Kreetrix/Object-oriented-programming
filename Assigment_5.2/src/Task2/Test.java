package Task2;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ArraySafe<String> threadSafeList = new ArraySafe<>();

        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                threadSafeList.add("Element " + i);
            }
        };

        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(addTask);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final size of the list: " + threadSafeList.size());
    }
}
