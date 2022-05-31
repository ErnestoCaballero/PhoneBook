package com.ernesto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File findFile = new File("./TestFiles/StageOne/find.txt");
        File unsortedDirectory = new File("./TestFiles/StageOne/directory.txt");

        // Linear Search procedure
        System.out.println("Start searching (linear search)...");
        long start = System.currentTimeMillis();
        String[] toFind = getInputArray(findFile);
        int found = countFoundElements(toFind, unsortedDirectory);
        long end = System.currentTimeMillis();
        long[] timeFrame = getTimeLapse(end - start);
        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.%n",
                found,
                toFind.length,
                timeFrame[0],
                timeFrame[1] ,
                timeFrame[2]);

        System.out.println();


        // Bubble Sort and Jump Search procedure
        System.out.println("Start searching (bubble sort + jump search)...");

        long sortTime1 = System.currentTimeMillis();
        String[] directory = getInputArray(unsortedDirectory);
        String[] sortedDirectory = sortStringArray(directory);
        formatToFind(toFind);
        formatDirectory(sortedDirectory);
        long sortTime2 = System.currentTimeMillis();
        long[] sortingTime = getTimeLapse(sortTime2 - sortTime1);

        long searchTime1 = System.currentTimeMillis();
        int foundJumping = countFoundElements(toFind, sortedDirectory);
        long searchTime2 = System.currentTimeMillis();
        long[] searchingTime = getTimeLapse(searchTime2 - searchTime1);

        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.\n",
                foundJumping,
                toFind.length,
                sortingTime[0] + searchingTime[0],
                sortingTime[1] + searchingTime[1],
                sortingTime[2] + searchingTime[2]);
        System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", sortingTime[0], sortingTime[1], sortingTime[2]);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", searchingTime[0], searchingTime[1], searchingTime[2]);

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
//        System.out.printf("Enter myJumpSearch | toFind = %s%n", value);
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int curr = 0;

        while (curr < arr.length) {
//            System.out.printf("\tChecking if element %d (%s) is %s | %s.compateTo(%s) = %d\n", curr, arr[curr], value, arr[curr], value, arr[curr].compareTo(value));
            if (arr[curr].equals(value)) {
//                System.out.printf("\t\tElement found!\n");
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
//                System.out.printf("\t\tEnter arr[curr].compareTo(value) > 0\n");
                for (int i = curr - 1; i > curr - step; i--) {
                    if (arr[i].compareTo(value) < 0) {
                        return false;
                    }
                    if (arr[i].equals(value)) {
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

    public static void formatDirectory(String[] arr) {
//        try (PrintWriter writer = new PrintWriter("./TestFiles/WritingFiles/formattedSortedDirectory.txt")) {
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split(" ");
            if (tmp.length > 2) {
                arr[i] = String.format("%s%s", tmp[1].toLowerCase(), tmp[2].toLowerCase());
//                    writer.printf("%s\n", arr[i]);
            } else {
                    arr[i] = String.format("%s", tmp[1].toLowerCase());
//                    writer.printf("%s\n", arr[i]);
            }
        }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

    }

    public static void formatToFind(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split(" ");
            if (tmp.length > 1) {
                arr[i] = String.format("%s%s", tmp[0].toLowerCase(), tmp[1].toLowerCase());
            } else {
                arr[i] = arr[i].toLowerCase();
            }
        }
    }
}
