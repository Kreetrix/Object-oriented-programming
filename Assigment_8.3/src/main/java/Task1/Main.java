package Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    String name;
    int age;
    String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Pekka 1", 25, "Rovaniemi"));
        people.add(new Person("Pekka 2", 30, "Espoo"));
        people.add(new Person("Pekka 3", 22, "Kauniainen"));
        people.add(new Person("Pekka 4", 35, "Espoo"));
        people.add(new Person("Pekka 5", 28, "Espoo"));

        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Sorted by age (ascending):");
        people.forEach(System.out::println);

        String targetCity = "Espoo";
        people.removeIf(person -> !person.getCity().equals(targetCity));
        System.out.println("\nFiltered by city (" + targetCity + "):");
        people.forEach(System.out::println);
    }
}