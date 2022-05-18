package jump.search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SearchInDecreasingArray {

    public static String[] getStringArrayFromFile(File file, int lineNumber) throws IOException {
        Scanner scanner = new Scanner(file);
        String[] arr;

        for (int i = 0; i < lineNumber - 1; i++) {
            scanner.nextLine();
        }

        arr = scanner.nextLine().split(" ");

        return arr;
    }
}
