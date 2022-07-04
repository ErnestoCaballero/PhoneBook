package com.ernesto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File findFile = new File("./TestFiles/StageOne/find.txt");
        File unsortedDirectory = new File("./TestFiles/StageOne/directory.txt");

        // Linear Search procedure
        System.out.println("Start searching (linear search)...");
        long startLinear = System.currentTimeMillis();
        String[] toFind = getInputArray(findFile);
        int found = countFoundElements(toFind, unsortedDirectory);
        long endLinear = System.currentTimeMillis();
        long[] timeFrame = getTimeLapse(endLinear - startLinear);
        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.%n",
                found,
                toFind.length,
                timeFrame[0],
                timeFrame[1] ,
                timeFrame[2]);

        System.out.println();


        // Bubble Sort and Jump Search procedure
        System.out.println("Start searching (bubble sort + jump search)...");

        // Bubble Sort
        long sortTime1 = System.currentTimeMillis();
        String[] directory = getDirectoryArray(unsortedDirectory);
        if (sortStringArray(directory, endLinear - startLinear)) {
            long sortStop = System.currentTimeMillis();
            long[] stopped = getTimeLapse(sortStop - sortTime1);
            long linearStart = System.currentTimeMillis();
            int linearFound = countFoundElements(toFind, unsortedDirectory);
            long linearEnd = System.currentTimeMillis();
            long[] linearTime = getTimeLapse(linearEnd - linearStart);
            System.out.printf("Found %s/%s entries. Time taken: %d min. %d sec. %d ms.\n",
                    linearFound,
                    toFind.length,
                    linearTime[0] + stopped[0],
                    linearTime[1] + stopped[1],
                    linearTime[2] + stopped[2]);
            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n", stopped[0], stopped[1], stopped[2]);
            System.out.printf("Searching time: %d min. %d sec. %d ms.", linearTime[0], linearTime[1], linearTime[2]);
            return;
        }

        long sortTime2 = System.currentTimeMillis();
        long[] sortingTime = getTimeLapse(sortTime2 - sortTime1);

        // JumpSearch
        long searchTime1 = System.currentTimeMillis();
        formatToFind(toFind);
        int foundJumping = countFoundElements(toFind, directory);
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

        System.out.println();


        // Quick Sort + Binary Search procedure
        System.out.println("Start searching (quick sort + binary search)...");

        // Quick Sort
        long quickSortTime1 = System.currentTimeMillis();
        String[] quickDirectory = getDirectoryArray(unsortedDirectory);
        quickSortArray(quickDirectory, 0, quickDirectory.length - 1);
        long quickSortTime2 = System.currentTimeMillis();
        sortingTime = getTimeLapse(quickSortTime2 - quickSortTime1);

        // Binary Search
        long binarySearchTime1 = System.currentTimeMillis();
        int foundBinary = countElementsBinary(toFind, quickDirectory);
        long binarySearchTime2 = System.currentTimeMillis();
        searchingTime = getTimeLapse(binarySearchTime2 - binarySearchTime1);

        System.out.printf("Found %d/%d entries. Time taken: %d min. %d sec. %d ms.\n",
                foundJumping,
                toFind.length,
                sortingTime[0] + searchingTime[0],
                sortingTime[1] + searchingTime[1],
                sortingTime[2] + searchingTime[2]);
        System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", sortingTime[0], sortingTime[1], sortingTime[2]);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", searchingTime[0], searchingTime[1], searchingTime[2]);

    }

    public static int countElementsBinary(String[] toFind, String[] directory) {
        int found = 0;
        for (String s : toFind) {
            if (binarySearch(directory, s)) {
                found++;
            }
        }
        return found;
    }

    public static boolean binarySearch(String[] arr, String value) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle].compareTo(value) == 0) {
                return true;
            } else if (arr[middle].compareTo(value) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }

    public static void quickSortArray(String[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int leftPointer = partition(arr, left, right);

        quickSortArray(arr, left, leftPointer - 1);
        quickSortArray(arr, leftPointer + 1, right);

    }

    public static int partition(String[] arr, int left, int right) {
        int leftPointer = left;
        int rightPointer = right;
        String pivot = arr[right];

        while (leftPointer < rightPointer) {
            while (arr[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }

        swap(arr, leftPointer, right);

        return leftPointer;
    }

    private static void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean sortStringArray(String[] arr, long ref) {
        long sortStart = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String x = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = x;
                }
                long iteration = System.currentTimeMillis();
                if (iteration - sortStart > ref * 10) {
                    return true;
                }
            }
        }

        return false;
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

    public static String[] getDirectoryArray(File input) {
        int countLines = 0;

        try (Scanner scanner = new Scanner(input); Scanner scanner1 = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                countLines++;
            }

            String[] directory = new String[countLines];
            int i = 0;

            while (scanner1.hasNextLine()) {
                String[] currName = scanner1.nextLine().split(" ");
                if (currName.length > 2) {
                    directory[i] = String.format("%s%s", currName[1].toLowerCase(), currName[2].toLowerCase());
                } else {
                    directory[i] = String.format("%s", currName[1].toLowerCase());
                }
                i++;
            }

            return directory;

        } catch (IOException e) {
            System.out.println("IOException encountered! " + e.getMessage());
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
