package com.neartack.stone.lessons.task2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Starter {
    //directory
   static String directory = "D:\\Java\\lessons\\StoneLessons\\resources\\task2\\reports\\";

    //partName
    static String emfSample = "emp_hrs_";
    static String reportSample = "report_";


    public static void main(String[] args) throws IOException {
        FileFinder.findFile(directory,emfSample);
        FileFinder.findFile(directory,reportSample);
        CompanyReportGenerator.readReports(directory);
      //  FileFinder.printFileList();
    }
}
