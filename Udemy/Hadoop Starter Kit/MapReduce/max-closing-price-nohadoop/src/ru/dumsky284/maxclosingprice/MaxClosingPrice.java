package ru.dumsky284.maxclosingprice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MaxClosingPrice {

    public static void main(String[] args) {

        long startTimeStamp = System.currentTimeMillis();
        System.out.println("Start: " + startTimeStamp);

        Map<String,Float> resultingMap = new HashMap();

        File f = new File("C:\\Users\\dumavla\\IdeaProjects\\stocks");
        Scanner fs = null;
        try {
            fs = new Scanner(f);
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc.getMessage());
        }

        while(fs.hasNextLine()) {
            String str = fs.nextLine();
            String[] items = str.split(",");

            String stock = items[1];
            Float closePrice = Float.parseFloat(items[6]);
            if(resultingMap.containsKey(stock)) {
                if (resultingMap.get(stock) < closePrice) {
                    resultingMap.replace(stock, closePrice);
                }
            }
            else {
                resultingMap.put(stock, closePrice);
            }
        }

        long endTimeStamp = System.currentTimeMillis();
        System.out.println("End: " + endTimeStamp);

        System.out.println("Total time: " + (endTimeStamp - startTimeStamp));

        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\dumavla\\IdeaProjects\\out");
            fileWriter.flush();
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(String key: resultingMap.keySet()) {
                printWriter.println(key + "," + resultingMap.get(key).toString());
            }
            fileWriter.close();
        } catch (IOException exc) {
            throw new RuntimeException(exc.getMessage());
        }
    }

}
