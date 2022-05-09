package fileclass;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadingTests {

    public static void main(String[] args) {
        File file = new File("./TestFiles/semicolonsfile.txt");

        // Print general info data of the file
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(new File(file.getParent()).getAbsolutePath()); // Get Parent Absolute Path
        System.out.println(file.lastModified());
        System.out.println(file.canRead());
        System.out.println();


        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] currLine = scanner.nextLine().split(";");
                for (String i : currLine) {
                    System.out.printf("%s ", i);
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("The file was not found! " + e.getMessage());
        }

        System.out.println();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] currLine = scanner.nextLine().split(";");
                int year = Integer.parseInt(currLine[0]);
                long id = Integer.parseInt(currLine[1]);
                String name = currLine[2];
                System.out.printf("The year is: %d | The id is: %d | The name is: %s", year, id, name);
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("The file was not found! " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid input! " + e.getMessage());
        }


    }
}















