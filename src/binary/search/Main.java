package binary.search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 8, 9, 10};

        File sortedFile = new File("./TestFiles/DataSets/binaryDataset_01.txt");
        System.out.println(binarySearchFile(sortedFile, 35));

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
