package fileclass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFileDemo {

    public static void main(String[] args) {
        String pathToHelloWorldJava = "/Users/ernestocaballero/Documents/JetbrainsAcademy/JavaDeveloperTrack/PhoneBook/" +
                "TestFiles/HelloWorld/HelloWorld.java";

        try {
            System.out.println(readFileAsString(pathToHelloWorldJava));
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }

    }

    public static String readFileAsString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
