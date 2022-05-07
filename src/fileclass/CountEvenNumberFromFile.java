package fileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountEvenNumberFromFile {

    public static void main(String[] args) {
        File file = new File("/Users/ernestocaballero/Downloads/dataset_91065.txt");
        int number;
        int evens = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number == 0) {
                    break;
                }
                if (number % 2 == 0) {
                    evens++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
            return;
        } catch (NoSuchElementException e) {
            System.out.println("Not a valid input: " + e.getMessage());
            return;
        }

        System.out.printf("Evens are: %d%n", evens);
    }
}
