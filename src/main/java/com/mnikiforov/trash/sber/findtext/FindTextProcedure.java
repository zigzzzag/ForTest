package com.mnikiforov.trash.sber.findtext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FindTextProcedure {

    static String SEARCH_PATH;
    static String SEARCH_TEXT;
    private static final Map<Double, String> DATA = new TreeMap<>();

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            System.err.println("args is invalid!!!");
            return;
        }

        SEARCH_PATH = args[0];
        if (SEARCH_PATH == null) {
            System.err.println("searchPath is empty!!!");
            return;
        }

        SEARCH_TEXT = args[1];
        if (SEARCH_TEXT == null) {
            System.err.println("searchText is empty!!!");
            return;
        }


        File searchDir = new File(SEARCH_PATH);
        if (searchDir.isDirectory()) {
            searchTextInDirectory(searchDir);
        } else {
            System.err.println("Directory " + SEARCH_PATH + " does not exists");
        }

        System.out.println();
        System.out.println("RESULT: ");
        for (String s : DATA.values()) {
            System.out.println(s);
        }
    }

    private static void searchTextInDirectory(File searchDir) {
        if (searchDir == null) {
            System.err.println("searchDir is null!!!");
            return;
        }

        for (File file : searchDir.listFiles()) {
            if (!file.isDirectory()) {
                searchInFile(file);
            } else {
                System.err.println(file.getName() + " is directory..");
            }
        }
    }

    private static void searchInFile(final File file) {
        System.out.println("search in " + file.getName() + " ...");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (isNeededLine(line)) {
                    fixInfo(file, line, lineNumber);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fixInfo(final File file, final String line, final int lineNumber) {
        String lineInfo = file.getName() + ":" + lineNumber + "; " + line;
        double totalTime = parseLine(line);
        if (totalTime > 100.0) {
            DATA.put(totalTime, lineInfo);
        }
    }

    private static double parseLine(String line) {
        try {
            String totalTime = line.substring(line.indexOf(SEARCH_TEXT) + SEARCH_TEXT.length(), line.indexOf("secs")).trim();
            return Double.parseDouble(totalTime);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static boolean isNeededLine(String line) {
        return line != null && line.contains(SEARCH_TEXT);
    }
}
