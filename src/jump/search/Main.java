package jump.search;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        File file = new File("./TestFiles/JumpSearch/dataset_searchDecreasing.txt");

        try {
            String[] inputOne = getStringArrayFromFile(file, 1);
            String[] inputTwo = getStringArrayFromFile(file, 2);

            int[] arr = new int[inputOne.length];
            int[] toFind = new int[inputTwo.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(inputOne[i]);
            }
            for (int i = 0; i < toFind.length; i++) {
                toFind[i] = Integer.parseInt(inputTwo[i]);
            }

            Arrays.sort(arr);
            Arrays.sort(toFind);

            for (int i : toFind) {
//                System.out.printf("Search for %d in toFind in arr: %d%n", i, myJumpSearch(arr, i) == -1 ? -1 : arr.length - myJumpSearch(arr, i) - 1);
                System.out.printf("%d ", myJumpSearch(arr, i) == -1 ? -1 : arr.length - myJumpSearch(arr, i) - 1);
            }


        } catch (IOException e) {
            System.out.printf("%s %s", "The file might not exists", e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("The data trying to be converted is not compatible! " + e.getMessage());
        }

    }

    public static int myJumpSearch(int[] arr, int value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int curr = 0;

        while (curr < arr.length) {
            if (arr[curr] == value) {
                return curr;
            } else if (arr[curr] < value) {
                if (curr + step >= arr.length) {
                    // Check last block
                    for (int i = curr; i < arr.length; i++) {
                        if (arr[i] == value) {
                            return curr;
                        }
                        curr++;
                    }
                    return -1;
                } else {
                    curr += step;
                }
            } else {
                // arr[curr] > value case
                for (int i = curr - 1; i > curr - step; i--) {
                    if (i < 0) {
                        return -1;
                    }
                    if (arr[i] == value) {
                        return i;
                    }
                }
                return -1;
            }
        }

        return -1;
    }

    public static int jumpSearch(int[] arr, int value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int curr = 1;

        while (curr <= arr.length) {
            if (arr[curr] == value) {
                return curr;
            } else if (arr[curr] > value) {
                int ind = curr - 1;

                while (ind > curr - step && ind >= 1) {
                    if (arr[ind] == value) {
                        return ind;
                    }
                    ind--;
                }
                return -1;
            }
            curr += step;
        }

        int ind = arr.length;

        while (ind > curr - step) {
            if (arr[ind] == value) {
                return ind;
            }
            ind--;
        }
        return -1;
    }

    public static int geeksJumpSearch(int[] arr, int value) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < value) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }

        while (arr[prev] < value) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (arr[prev] == value) {
            return prev;
        }

        return -1;
    }

    public static String[] getStringArrayFromFile(File file, int lineNumber) throws IOException {
        Scanner scanner = new Scanner(file);
        String[] arr;

        for (int i = 0; i < lineNumber - 1; i++) {
            scanner.nextLine();
        }

        arr = scanner.nextLine().split(" ");

        return arr;
    }
}
