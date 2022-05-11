package writerclasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFileWriter {

    public static void main(String[] args) {
        File file = new File("./TestFiles/WritingFiles/firstFileWriter.txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("From the FileWriter class\n\n");
            writer.write("Hello, Ernesto\nYou're a great Java programmer!");
        } catch (IOException e) {
            System.out.println("IOException! " + e.getMessage());
        }

        File file1 = new File("./TestFiles/WritingFiles/firstPrintWriter.txt");

        try (PrintWriter printWriter = new PrintWriter(file1)) {
            printWriter.println("From PrintWriter class");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hey, tell me which number to write in the file: ");
            int number = scanner.nextInt();
            printWriter.printf("The number you wrote was %d%n", number);
            printWriter.printf("Great, you've write into this file!");
        } catch (IOException e) {

        }
    }
}
