package quick.sort;

import java.awt.image.renderable.RenderableImage;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        printArray(numbers);


    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[right];
//        System.out.printf("Pivot %d \n", pivot);
        int leftPointer = partition(arr, left, right, pivot);

        quickSort(arr, left, leftPointer - 1);
        quickSort(arr, leftPointer + 1, right);

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

//            System.out.printf("\tSwapping element %d with %d\n", arr[leftPointer], arr[rightPointer]);
            swap(arr, leftPointer, rightPointer);
//            System.out.printf("\t");
//            printArray(arr);

        }

//        System.out.printf("\tNow swapping pivot to middle\n");
        swap(arr, leftPointer, right);
//        System.out.printf("\t");
//        printArray(arr);
        return leftPointer;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
