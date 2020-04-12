package com.neartack.stone.lessons.task2;

import com.neartack.stone.lessons.MyTestClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CompanyReportGenerator {
    public static final Logger LOGGER = LoggerFactory.getLogger(CompanyReportGenerator.class);

    // private static Map<String, Double> totalReportMap = new HashMap<>();
    private static Map<Integer, String> companyNameMap = new HashMap<>();
    private static Map<Integer, Double> totalMap = new HashMap<>();
    private static Map<Integer, String> monthMap = new HashMap<>();
    private static int keyForMap = 1;
    private static ArrayList<Integer> keys = new ArrayList<>();


    public static void readReports(String directory) {
        for (Map.Entry<Integer, String> entry : FileFinder.filesMap.entrySet()) {
            String value = entry.getValue();

            FileReader fileReader = null;
            try {
                fileReader = new FileReader(directory + value);
            } catch (FileNotFoundException e) {
                LOGGER.error("FileNotFoundException при чтении файла: " + value + " при выполнении: " + e.getStackTrace()[1].getMethodName());
            }
            Scanner scanner = new Scanner(fileReader);


            ArrayList<String> allLineReport = new ArrayList<>();
            while (scanner.hasNextLine()) {
                allLineReport.add(scanner.nextLine());
            }


            String companyName = null;
            double totalProceeds = 0;
            boolean flagTotal = false;
            String month = null;

            for (String line : allLineReport) {

                if (line.contains("companyName:")) {
                    int index = line.indexOf(":") + 1;
                    companyName = line.substring(index);
                }

                if (line.contains("total:")) {
                    int index = line.indexOf(":") + 1;
                    flagTotal = true;
                    try {
                        double proceed = Double.parseDouble(line.substring(index));
                        totalProceeds = totalProceeds + proceed;
                    } catch (NumberFormatException e) {
                        LOGGER.info("NumberFormatException");
                        LOGGER.error("NumberFormatException при чтении файла: " + value + " при выполнении: " + e.getStackTrace()[1].getMethodName());

                        companyName = null;
                    }
                }

                if (line.contains("month:")) {
                    int index = line.indexOf(":") + 1;
                    month = line.substring(index);
                }


            }
            if (companyName != null && flagTotal && month != null) {
                companyNameMap.put(keyForMap, companyName);
                totalMap.put(keyForMap, totalProceeds);
                monthMap.put(keyForMap, month);
                keys.add(keyForMap);
                keyForMap++;

            }
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();

        }

        printReport();

    }

    public static void printReport() {

        for (Map.Entry<Integer, String> entry : companyNameMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("Для просмотра отчета введите порядковый номер компании");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int key = Integer.parseInt(scanner.nextLine());
                if (keys.contains(key)) {
                    System.out.println(companyNameMap.get(key) + " - " + totalMap.get(key) + " " + monthMap.get(key));
                } else {
                    System.out.println("Введено не верное значение");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не верное значение");
            }
        }
        scanner.close();
    }
}