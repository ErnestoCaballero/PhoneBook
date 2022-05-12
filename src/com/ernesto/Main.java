package com.ernesto;

import jdk.swing.interop.SwingInterOpUtils;
import superkey.Developer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File smallFind = new File("./TestFiles/StageOne/small_find.txt");
        File smallDirectory = new File("./TestFiles/StageOne/small_directory.txt");
        System.out.println("Start searching...");
        long start = System.currentTimeMillis();

        String[] toFind = getInputArray(smallFind);

        int found = 0;

        try (Scanner scanner = new Scanner(smallDirectory)) {
            String currentName;
            while (scanner.hasNextLine()) {
                scanner.next();
                currentName = scanner.nextLine().trim();
                if (elementExists(toFind, currentName)) {
                    found++;
                }
                if (found == toFind.length) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println();
        }

        long end = System.currentTimeMillis();
        long lapse = end - start;
        long minutes = lapse / 1_000 / 60;
        long seconds = (lapse / 1_000) % 60;
        long ms = lapse % 1000;

        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.%n", found, toFind.length, minutes, seconds , ms);

    }

    public static String[] getInputArray(File input) {
        int countLines = 0;

        try (Scanner scanner = new Scanner(input); Scanner scanner1 = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                countLines++;
            }

            String[] toFind = new String[countLines];
            int i = 0;

            while (scanner1.hasNextLine()) {
                toFind[i] = scanner1.nextLine();
                i++;
            }

            return toFind;

        } catch (IOException e) {
            System.out.println();
        }

        return null;
    }

    static boolean elementExists(String[] arr, String toCheck) {
        for (String s : arr) {
            if (s.equals(toCheck)) {
                removeElementFromArray(arr, toCheck);
                return true;
            }
        }
        return false;
    }

    public static String[] removeElementFromArray(String[] toReplace, String toRemove) {
        boolean contains = false;

        for (String s : toReplace) {
            if (s.equals(toRemove)) {
                contains = true;
            }
        }

        if (!contains) {
            System.out.println("The element doesn't exist in the Array!\nReturning original Array");
            return toReplace;
        }

        String[] result = new String[toReplace.length - 1];

        for (int i = 0; i < toReplace.length - 1; i++) {
            if (!toReplace[i].equals(toRemove)) {
                result[i] = toReplace[i];
            } else {
                for (int j = i; j < toReplace.length - 1; j++) {
                    result[j] = toReplace[j + 1];
                }
                break;
            }
        }

        result[result.length - 1] = toReplace[toReplace.length - 1];

        return result;
    }
}
