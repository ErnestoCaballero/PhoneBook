package fileclass;

/*
    Here's a file that stores data on the world population since 1950, according to the United States Census Bureau (2017).

    Download the file and write a Java program to find out in what year the largest increase in population occurred as
    compared to the previous year.

    The file has two columns: year and population. Take a look at it to understand the format better.

    Enter the resulting year.
 */

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WorldPopulation {

    public static void main(String[] args) {
        double maxChange = Double.MIN_VALUE;
        String year;
        String maxYear = "";
        double change;
        long number;
        File file = new File("./TestFiles/DataSets/dataset_worldPopulation.txt");

        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();

            String previousYear = scanner.next();
//            System.out.println(previousYear);
            long previousElement = scanner.nextLong();
//            System.out.println(previousElement);

            while (scanner.hasNextLine()) {
                year = scanner.next();
                number = scanner.nextLong();
                change = number - previousElement;
                System.out.printf("year: %s | population %d | change: %f%n", year, number, change);

                if (change > maxChange) {
                    maxChange = change;
                    maxYear = year;
                }

                previousElement = number;
            }

        } catch (IOException e) {
            System.out.println("IOException found!");
        } catch (NoSuchElementException e) {

        }

        System.out.printf("The year with the highest rate change was %s", maxYear);
    }
}
