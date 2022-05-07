package fileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountEvenNumberFromFile {

    public static void main(String[] args) {
        File file = new File("/Users/ernestocaballero/Downloads/dataset_91065.txt");
        int number;
        int evens = 0;
        int counter = 1;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String value = scanner.nextLine();
//                System.out.printf("Number to parse: %s in records #%d%n", value, counter);
                number = Integer.parseInt(value);
                counter++;
                if (number == 0) {
                    break;
                }
                if (number % 2 == 0) {
                    evens++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        } catch (NumberFormatException e) {
            System.out.println("Not a valid input: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException happen: " + e.getMessage());
        }

        System.out.printf("Evens are: %d%n", evens);
    }
}
