package hashing;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet();

        File input = new File("./TestFiles/StageOne/find.txt");

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String currName = scanner.nextLine();
                hashSet.add(currName);
            }
        } catch (IOException e) {
            System.out.println("IOException found! " + e.getMessage());
        }

        for (String s : hashSet) {
            System.out.println(s);
        }

    }
}
