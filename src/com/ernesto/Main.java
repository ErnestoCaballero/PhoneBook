package com.ernesto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File findFile = new File("./TestFiles/StageOne/find.txt");
        File directoryFile = new File("./TestFiles/StageOne/directory.txt");
        System.out.println("Start searching...");

        long start = System.currentTimeMillis();
        String[] toFind = getInputArray(findFile);
        int found = countFoundElements(toFind, directoryFile);
        long end = System.currentTimeMillis();
        long[] timeFrame = getTimeLapse(end - start);

        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.%n", found, toFind.length, timeFrame[0], timeFrame[1] , timeFrame[2]);

    }

    public static int countFoundElements(String[] toFind, File directory) {
        int found = 0;
        int line = 0;

        try (Scanner scanner = new Scanner(directory); PrintWriter writer = new PrintWriter("./TestFiles/WritingFiles/directoryResult.txt")) {
            writer.printf("NAME;LINE_NUMBER%n");
            String currentName;
            while (scanner.hasNextLine()) {
                line++;
                scanner.next();
                currentName = scanner.nextLine().trim();
                if (elementExists(toFind, currentName)) {
                    found++;
                    writer.printf("%s;%d%n", currentName, line);
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
