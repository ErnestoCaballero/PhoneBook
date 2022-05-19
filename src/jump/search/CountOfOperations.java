package jump.search;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountOfOperations {

    public static void main(String[] args) {
        File output = new File("./TestFiles/WritingFiles/CountOfOperations.txt");
        File file = new File("./TestFiles/JumpSearch/dataset_countOfOperations.txt");

        int comparisons = 0;

        try (PrintWriter writer = new PrintWriter(output)) {
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

            for (int i : toFind) {
                int[] result = myJumpSearch(arr, i);
                comparisons += result[1];
                writer.printf("Search element: %d | Index found: %d | Comparisons: %d%n", i, result[0], result[1]);
            }

        } catch (IOException e) {
            System.out.printf("The file might not have been found! %s", e.getMessage());
        } catch (NumberFormatException e) {
            System.out.printf("There is not a valid argument to parse! %s", e.getMessage());
        }

        System.out.println(comparisons);

    }

    public static int[] myJumpSearch(int[] arr, int value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int[] result = new int[2];
        int curr = 0;
        int comparisons = 0;

        while (curr < arr.length) {
            if (arr[curr] == value) {
                comparisons++;
                result[0] = curr;
                result[1] = comparisons;
                return result;
            } else if (arr[curr] < value) {
                comparisons++;
                if (curr + step >= arr.length) {
                    // Check last block
                    for (int i = curr; i < arr.length; i++) {
                        if (arr[i] == value) {
                            result[0] = curr;
                            result[1] = comparisons;
                            return result;
                        }
                        curr++;
                    }
                    result[0] = -1;
                    result[1] = comparisons;
                    return result;
                } else {
                    curr += step;
                }
            } else {
                // arr[curr] > value case
                comparisons++;
                for (int i = curr - 1; i > curr - step; i--) {

                    comparisons++;
                    if (i < 0) {
                        result[0] = -1;
                        result[1] = comparisons;
                        return result;
                    }
                    if (arr[i] == value) {
                        result[0] = i;
                        result[1] = comparisons;
                        return result;
                    }
                }

                result[0] = -1;
                result[1] = comparisons;
                return result;
            }
        }

        result[0] = -1;
        result[1] = comparisons;
        return result;
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
