package binary.search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0, 14, 19, 23, 28, 30, 33, 44, 52, 52, 62, 65, 76, 91, 94};
        int[] search = {83, 42, 3, 11, 72, 17, 32, 42, 68, 13, 11, 6, 22, 40, 26};

//        System.out.println(arr[leftBinarySearch(arr, 6)]);

        for (int i : search) {
            System.out.printf("%d ", arr[approximateSearch(arr, i)]);
        }

    }

    public static int myBinarySearch(int[] arr, int tgt) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == tgt) {
                return middle;
            } else if (tgt > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    // Searches the nearest value to the target value
    public static int approximateSearch(int[] arr, int tgt) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (middle + 1 >= arr.length) return middle;

            if (arr[middle] == tgt) {
                return middle;
            } else if (tgt > arr[middle]) {
                if (Math.abs(arr[middle] - tgt) <= Math.abs(arr[middle + 1] - tgt)) {
                    return middle;
                }

                if (Math.abs(arr[left] - tgt) <= Math.abs(arr[middle + 1] - tgt)) {
                    return left;
                }

                left = middle + 1;
            } else {
                if (right - 1 < 0) {
                    return right;
                }

                if (Math.abs(arr[middle] - tgt) <= Math.abs(arr[middle - 1] - tgt)) {
                    return middle;
                }

                if (arr[right] - tgt < arr[middle - 1] - tgt) {
                    return right;
                }

                right = middle - 1;
            }
        }

        return left;
    }

    static int binarySearchFile(File sortedFile, int tgt) {

        try (Scanner scanner = new Scanner(sortedFile); Scanner input = new Scanner(sortedFile)) {
            int size = 0;

            while (scanner.hasNextInt()) {
                scanner.nextInt();
                size++;
            }

            int[] arr = new int[size];
            int i = 0;

            while (input.hasNextInt()) {
                arr[i] = input.nextInt();
                i++;
            }

            return myBinarySearch(arr, tgt);

        } catch (IOException e) {
            System.out.println("IOException found! " + e.getMessage());
        }

        return -1;
    }

    static int binarySearchN(int[] arr, int n) {
        if (n < 0 || n > arr.length) {
            System.out.println("Element n doesn't exist");
            return -1;
        }

        int tgt = arr[n];

        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            comparisons++;

            if (arr[mid] == tgt) {
                return comparisons;
            } else if (tgt > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    static int binarySearch7(int[] arr) {
        int tgt = arr[6];

        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            comparisons++;

            if (arr[mid] == tgt) {
                System.out.println("Number found!");
                return comparisons;
            } else if (tgt > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Number not found :(");
        return -1;
    }


}
