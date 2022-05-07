package fileclass;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

public class SumNumbersInFile {

    public static void main(String[] args) {
        File file = new File("./TestFiles/DataSets/dataset_sumNumbers.txt");
        int sum = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                sum += Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("The input is not valid!");
        } catch (IOException e) {
            System.out.println("IOException occur!");
        }

        System.out.printf("The sum of the numbers in the file is %d%n", sum);

    }
}
