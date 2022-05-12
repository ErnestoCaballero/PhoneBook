package linear.search;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File input = new File("./TestFiles/arraysToSearch.txt");
        File output = new File("./TestFiles/WritingFiles/searchArray.txt");

        printStepsFromFile(input);

        try (Scanner scanner = new Scanner(input); PrintWriter writer = new PrintWriter(output)) {
            int iterations = 0;
            while (scanner.hasNextLine()) {
                String[] array1 = scanner.nextLine().split(" ");
                String[] array2 = scanner.nextLine().split(" ");
                iterations++;
                int result = countSteps(array1, array2);
                System.out.println(result);
                System.out.println("Writing Result into file...");
                writer.printf("The iteration %d output the value of %d%n", iterations, result);
            }
        } catch (IOException e) {
            System.out.println("IOException! " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("The file may not have one line at the end! " + e.getMessage());
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

    static void printStepsFromFile(File input) {
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String[] array1 = scanner.nextLine().split(" ");
                String[] array2 = scanner.nextLine().split(" ");
                int result = countSteps(array1, array2);
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("An IOException has occur");
        } catch (NoSuchElementException e) {
            System.out.println("The file may not have one line at the end! " + e.getMessage());
        }
    }

}
