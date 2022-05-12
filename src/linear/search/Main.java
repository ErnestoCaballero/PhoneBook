package linear.search;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] arr1 = {0, 4, 8, 0, 6, 1, 4, 8, 0, 7};
//        int[] arr2 = {3, 2, 9, 0, 6, 9, 2, 2, 5, 7};
//        String[] arr1 = {"0", "4", "8", "0", "6", "1", "4", "8", "0", "7"};
//        String[] arr2 = {"3", "2", "9", "0", "6", "9", "2", "2", "5", "7"};
//
//        System.out.println(countSteps(arr1, arr2));
//
//        System.out.println();

        File file = new File("./TestFiles/arraysToSearch.txt");
        File output = new File("./TestFiles/WritingFiles/searchArray.txt");

        try (Scanner scanner = new Scanner(file); PrintWriter writer = new PrintWriter(output)) {
            String[] array1 = scanner.nextLine().split(" ");
            String[] array2 = scanner.nextLine().split(" ");
            int result = countSteps(array1, array2);
            System.out.println(result);
            System.out.println("Writing Result into file...");
            writer.printf("The iteration %d output the value of %d", 1, result);
        } catch (IOException e) {

        }

    }

    static int countSteps(int[] toFind, int[] toCheck) {
        int steps = 0;

        for (int i = 0; i < toFind.length; i++) {
            for (int j : toCheck) {
                steps++;
                if (j == toFind[i]) {
                    break;
                }
            }
        }

        return steps;
    }

    static int countSteps(String[] toFind, String[] toCheck) {
        int steps = 0;

        for (int i = 0; i < toFind.length; i++) {
            for (String j : toCheck) {
                steps++;
                if (j.equals(toFind[i])) {
                    break;
                }
            }
        }

        return steps;
    }

}
