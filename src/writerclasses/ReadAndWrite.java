package writerclasses;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadAndWrite {

    public static void main(String[] args) {
        File fileToRead = new File("./TestFiles/DataSets/dataset_sumNumbers.txt");
        File fileToWrite = new File("./TestFiles/WritingFiles/evenOrOdd.txt");

        try (Scanner scanner = new Scanner(fileToRead); FileWriter writer = new FileWriter(fileToWrite)) {
            while (scanner.hasNextLine()) {
                int number = scanner.nextInt();
                if (number % 2 == 0) {
                    writer.write(number + ";even;" + Math.round(Math.random() * 1000) + "\n");
                } else {
                    writer.write(number + ";odd;" + Math.round(Math.random() * 1000) + "\n");
                }
            }
        } catch (IOException e) {

        }

        System.out.println("Finish writing the file");

    }
}
