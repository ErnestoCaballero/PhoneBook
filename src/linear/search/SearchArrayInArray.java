package linear.search;

/*
    SEARCHING FOR AN ARRAY IN AN ARRAY
    We search for every value of the first array in the second array using linear search.

    Download the file and figure out the number of comparison steps required for a complete execution of the algorithm?
 */

import java.io.File;

public class SearchArrayInArray {

    public static void main(String[] args) {
        File input = new File("./TestFiles/DataSets/hyperskill-dataset-60677906.txt");

        Main.printStepsFromFile(input); // prints 57
    }
}
