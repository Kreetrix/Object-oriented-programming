package Task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String csvFile = "file.csv";
        String line;
        String csvSplitBy = ",";

        try (FileWriter writer = new FileWriter(csvFile)) {
            long a = 0;
            long b = 1;
            int max = 60;

            writer.append("Index,Fibonacci Number\n");

            writer.append("1,").append(String.valueOf(a)).append("\n");
            writer.append("2,").append(String.valueOf(b)).append("\n");

            for (int i = 3; i <= max; i++) {
                long next = a + b;
                writer.append(String.valueOf(i)).append(",").append(String.valueOf(next)).append("\n");

                a = b;
                b = next;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);

                for (String column : columns) {
                    System.out.print(column + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
