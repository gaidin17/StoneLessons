package com.neartack.stone.lessons.task2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class FileFinder {
    static Map<Integer, String> filesMap = new HashMap<>();
    static int keyCount = 1;

    public static void findFile(String directory, String partName) {
        File file = new File(directory);
        if (!file.exists()) {
            System.out.println(directory + " не существует");
        }

        File[] listFiles = file.listFiles(new FileNameFilter(partName));
              if (listFiles.length == 0) {
            System.out.println(directory + " не содержит файлов с названием содержащим -" + partName);
        } else {
            for (File f : listFiles) {
                filesMap.put(keyCount, f.getName());
                keyCount++;
            }
        }

    }

//    public static void printFileList() {
//        System.out.println("Список отчетов:");
//        for (Map.Entry<Integer, String> entry : filesMap.entrySet())
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//    }

}


