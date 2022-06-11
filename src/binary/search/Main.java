package binary.search;

public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 13, 19, 20, 24, 26, 30, 34, 35, 40};
        System.out.println(myBinarySearch(arr, 34));

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
}
