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

        int found = countFoundElements(toFind, smallDirectory);

        long end = System.currentTimeMillis();
        
        long[] timeFrame = getTimeLapse(end - start);
        long minutes = timeFrame[0];
        long seconds = timeFrame[1];
        long ms = timeFrame[2];

        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.%n", found, toFind.length, minutes, seconds , ms);

    }

    public static int countFoundElements(String[] toFind, File directory) {
        int found = 0;

        try (Scanner scanner = new Scanner(directory)) {
            String currentName;
            while (scanner.hasNextLine()) {
                scanner.next();
                currentName = scanner.nextLine().trim();
                if (elementExists(toFind, currentName)) {
                    found++;
                }
                if (found == toFind.length) {
                    return found;
                }
            }

        } catch (IOException e) {
            System.out.println("File might not have been found!");
        }

        return found;
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

    public static long[] getTimeLapse(long lapse) {
        long[] result = new long[3];
        long minutes = lapse / 1_000 / 60;
        result[0] = minutes;
        long seconds = (lapse / 1_000) % 60;
        result[1] = seconds;
        long ms = lapse % 1000;
        result[2] = ms;

        return result;
    }
}
