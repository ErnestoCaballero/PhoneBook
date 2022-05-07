package fileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountEvenNumberFromFile {

    public static void main(String[] args) {
        String fileLocation = "/Users/ernestocaballero/Downloads/dataset_91065.txt";
//        int number;
//        int evens = 0;

        try {
            String fullFile = new String(Files.readAllBytes(Paths.get(fileLocation)));
            System.out.println(fullFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileLocation);
            return;
        } catch (NoSuchElementException e) {
            System.out.println("Not a valid input: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("IOException found!");
            return;
        }

//        System.out.printf("Evens are: %d%n", evens);
    }
}
