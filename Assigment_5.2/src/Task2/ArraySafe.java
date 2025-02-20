package Task2;

import java.util.ArrayList;

public class ArraySafe<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized void remove(T element) {
        list.remove(element);
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized ArrayList<T> getList() {
        return new ArrayList<>(list);
    }
}