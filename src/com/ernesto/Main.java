package com.ernesto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File findFile = new File("./TestFiles/StageOne/small_find.txt");
        File unsortedDirectory = new File("./TestFiles/StageOne/small_directory.txt");
        System.out.println(unsortedDirectory.isFile());
        System.out.println("Start searching...");

        // Linear Search procedure
        long start = System.currentTimeMillis();
        String[] toFind = getInputArray(findFile);
        int found = countFoundElements(toFind, unsortedDirectory);
        long end = System.currentTimeMillis();
        long[] timeFrame = getTimeLapse(end - start);
        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.%n", found, toFind.length, timeFrame[0], timeFrame[1] , timeFrame[2]);

        System.out.println();


        // Bubble Sort and Jump Search procedure
        String[] directory = getInputArray(unsortedDirectory);
        String[] sortedDirectory = sortStringArray(directory);
        int foundJumping = countFoundElements(toFind, sortedDirectory);
//        System.out.printf("Elements found using Jump Search Algorithm: %d", foundJumping);

        for (String s : sortedDirectory) System.out.printf("%s\n", s);



    }

    public static String[] sortStringArray(String[] array) {
        String[] arr = Arrays.copyOf(array, array.length);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                String[] currArr = arr[j].split(" ");
                String curr = currArr.length < 3 ? String.format("%s", currArr[1].toLowerCase()) : String.format("%s%s", currArr[1].toLowerCase(), currArr[2].toLowerCase());
                String[] nextArr = arr[j + 1].split(" ");
                String next = nextArr.length < 3 ? String.format("%s", nextArr[1].toLowerCase()) : String.format("%s%s", nextArr[1].toLowerCase(), nextArr[2].toLowerCase());
                if (curr.compareTo(next) > 0) {
                    String x = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = x;
                }
            }
        }

        return arr;
    }

    public static int countFoundElements(String[] toFind, String[] directory) {
        int found = 0;
        for (String s : toFind) {
            if (myJumpSearch(directory, s)) {
                found++;
            }
        }

        return found;
    }

    public static boolean myJumpSearch(String[] arr, String value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int curr = 0;


        while (curr < arr.length) {
            if (arr[curr].equals(value)) {
                return true;
            } else if (arr[curr].compareTo(value) < 0) {
                if (curr + step >= arr.length) {
                    // Check last block
                    for (int i = curr; i < arr.length; i++) {
                        if (arr[curr].equals(value)) {
                            return true;
                        }
                        curr++;
                    }
                    return false;
                } else {
                    curr += step;
                }
            } else {
                // arr[curr].compareTo(value) > 0
                for (int i = curr - 1; i > curr - step; i--) {
                    if (arr[curr].compareTo(value) < 0) {
                        return false;
                    }
                    if (arr[curr].equals(value)) {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }

    public static int countFoundElements(String[] toFind, File directory) {
        int found = 0;
        int line = 0;

        try (Scanner scanner = new Scanner(directory); PrintWriter writer = new PrintWriter("./TestFiles/WritingFiles/directoryResult.txt")) {
            writer.printf("PHONE_NUMBER;NAME;LINE_NUMBER%n");
            String currentName;
            while (scanner.hasNextLine()) {
                line++;
                String phoneNumber=scanner.next();
                currentName = scanner.nextLine().trim();
                if (elementExists(toFind, currentName)) {
                    found++;
                    writer.printf("%s;%s;%d%n", phoneNumber, currentName, line);
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

    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }
}
