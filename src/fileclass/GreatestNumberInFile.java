package fileclass;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GreatestNumberInFile {

    public static void main(String[] args) {
        File file = new File("./TestFiles/DataSets/dataset_greatestNumber.txt");
        int max = Integer.MIN_VALUE;
        int number;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                number = scanner.nextInt();
                if (number > max) {
                    max = number;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occur!");
        } catch (InputMismatchException e) {
            System.out.println("Not valid Input! ");
            return;
        }

        System.out.printf("The max number in the list is %d", max);
    }
}
