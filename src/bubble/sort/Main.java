package bubble.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {12, 8, 11, 10, 14, 16, 13, 10};
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int x = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = x;
                }
            }
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        System.out.printf("{ ");
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.printf("}\n");
    }
}
