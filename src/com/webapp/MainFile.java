package com.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) {

        String filePath = ".\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        // output of filenames and subdirectories
        File dir = new File(".\\src\\com\\webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        File rootDir = new File(".");
        // recursive traversal and output of filenames in directories and subdirectories
        printFilenames(rootDir);
        // recursive output of directories and files with offsets
        printFilesWithOffsets(rootDir, "");

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFilenames(File rootDir) {
        if (rootDir.isDirectory()) {
            File[] directoryFiles = rootDir.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        printFilenames(file);
                    } else {
                        System.out.println(file.getName());
                    }
                }
            }
        }
    }

    private static void printFilesWithOffsets(File rootDir, String offset) {
        if (rootDir.isDirectory()) {
            File[] directoryFiles = rootDir.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        System.out.println(offset + "D: " + file.getName());
                        printFilesWithOffsets(file, offset + "  ");
                    } else {
                        System.out.println(offset + "F: " + file.getName());
                    }
                }
            }
        }
    }
}
