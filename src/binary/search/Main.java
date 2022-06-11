package binary.search;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
//        System.out.println(myBinarySearch(arr, 34));
        System.out.println("Took " + binarySearch7(arr) + " iterations");
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
