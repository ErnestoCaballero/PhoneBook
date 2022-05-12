package linear.search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HowManyRepetitions {

    public static void main(String[] args) {
        File file = new File("./TestFiles/DataSets/countRepetitions.txt");

//        System.out.println(countRepetitions(file, "7"));

        System.out.println(countRepetitions(file));



    }

    static int countRepetitions(File file, String ref) {
        int count = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (scanner.next().equals(ref)) {
                    count++;
                }
            }

        } catch (IOException e) {
            System.out.println("IOException occur! " + e);
        }

        return count;
    }

    /*
    Reads the first element of the file as the element to check for occurences,
    then counts the repetitions on nextLine
     */

    static int countRepetitions(File file) {
        int count = 0;
        try (Scanner scanner = new Scanner(file)) {
            String ref = scanner.nextLine();
            while (scanner.hasNext()) {
                if (scanner.next().equals(ref)) {
                    count++;
                }
            }

        } catch (IOException e) {
            System.out.println("IOException occur! " + e);
        }

        return count;
    }
}
