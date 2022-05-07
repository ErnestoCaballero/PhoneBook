package fileclass;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SomeExceptions {

    public static void main(String[] args) {
        // Using the java.io package
        File file = new File("./TestFiles/DataSets/testFile.txt");
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("IOException occur!");
        } catch (NoSuchElementException e) {
            System.out.println("The element doesn't exist. The file might be empty!");
        }

        // Using the java.nio.file package


    }
}
