package Task3;

import java.io.*;

public class Main {
    private final static String FILENAME = "enrollment.dat";
    public static void main(String[] args) {
        File f = new File(FILENAME);
        Student student = new Student(1, "Pekka", 30);
        Course course = new Course("10341", "Kurssi", "Matti");
        Enrollment enrollment = new Enrollment(student, course, "01.01.2025");

        try (
                FileOutputStream outputstream = new FileOutputStream(FILENAME);
                ObjectOutputStream objects = new ObjectOutputStream(outputstream);
        ) {
            objects.writeObject(enrollment);
            System.out.println("Enrollment object written to file.");
        } catch (Exception e) {
            System.err.println("Writing enrollment: " + e);
        }

        if (f.exists() && f.isFile()) {
            try (
                    FileInputStream inputstream = new FileInputStream(FILENAME);
                    ObjectInputStream objects = new ObjectInputStream(inputstream);
            ) {
                enrollment = (Enrollment) objects.readObject();
                System.out.println("Enrollment object read from file.");
            } catch (Exception e) {
                System.err.println("Reading enrollment: " + e);
            }
        } else {
            System.err.println("File does not exist or is not a file.");
        }

        System.out.println("Enrollment: " + enrollment);
    }
}
