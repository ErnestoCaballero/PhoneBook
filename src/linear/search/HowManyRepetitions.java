package linear.search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HowManyRepetitions {

    public static void main(String[] args) {
        File file = new File("./TestFiles/DataSets/repetitionsFile.txt");

    }

    int countRepetitions(File file, String ref) {
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
}
