package Task1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

enum Names {
    AIKA,
    ULKOTALO,
    SISA,
}

public class Main {
    public static void main(String[] args) {
        String[] columnNames = new String[0];
        boolean header = true;
        URL myUrl;
        try {
            myUrl = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        try {
            InputStream istream = myUrl.openStream();

            InputStreamReader istreamreader = new InputStreamReader(istream);

            BufferedReader reader = new BufferedReader(istreamreader);
            String line;

            ArrayList<Double> temp = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (header) {
                    columnNames = line.split(";");
                    header = false;
                } else {
                    String[] columns = line.split(";");
                    for (int i = 0; i < columnNames.length; i++) {
                        if(columnNames[i].equals("Aika") && columns[i].contains("01.01.2023")){
                            temp.add(Double.parseDouble(columns[i+Names.ULKOTALO.ordinal()].replace(",",".")));
                        }
                    }
                }
            }
            double sum = 0;
            for(Double d : temp){
                sum += d;
            }
            if(!temp.isEmpty()){
                System.out.printf("Average temperature: %.2f", sum / temp.size());
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}