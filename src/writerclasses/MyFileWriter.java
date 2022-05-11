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


    }
}
