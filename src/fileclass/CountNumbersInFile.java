package fileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountNumbersInFile {

    public static void main(String[] args) {
        int element = 1;
        int count = 0;
        int number;

        try (Scanner scanner = new Scanner(new File("./TestFiles/DataSets/dataset_countnumbers.txt"))) {
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                System.out.printf("The element %d has the value of %d%n", element, number);
                element++;
                if (number >= 9999) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception!");
        }

        System.out.printf("Total of numbers greater than or equal to 9,999 are: %d%n", count);
    }
}
