package writerclasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {

    public static void main(String[] args) {
        File file = new File("./TestFiles/WritingFiles/firstWriter.txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, Ernesto\nYou're a great programmer!");
        } catch (IOException e) {
            System.out.println("IOException! " + e.getMessage());
        }
    }
}
