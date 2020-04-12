package com.neartack.stone.lessons.task2;

import java.io.File;
import java.io.FilenameFilter;


public class FileNameFilter implements FilenameFilter {
    private String partName;

    public FileNameFilter(String partName) {
        this.partName = partName.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".txt") && name.toLowerCase().contains(partName);
    }
}
