package fileclass;

import java.io.File;

public class Main {

    public static void main(String[] args) {
//        java.io.File file = new java.io.File("/Users/ernestocaballero/Documents/Udemy/BashMastery/scripts/our_first_script");
//        System.out.println(file.getName());
//        System.out.println(file.isDirectory());
//        System.out.println(file.isFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.canExecute());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        file.listFiles();
//        System.out.println(file.lastModified());
//        System.out.println(File.separator);

        File directory = new File("/Users/ernestocaballero/Documents/JetbrainsAcademy/JavaDeveloperTrack/PhoneBook/TestFiles/FilesTraversal01");
        printAllFiles(directory);
        System.out.println();

        File file1 = new File("/Users/ernestocaballero/Documents/JetbrainsAcademy/" +
                "JavaDeveloperTrack/PhoneBook/TestFiles/FilesTraversal01/file1.txt");
        File file2 = new File("/Users/ernestocaballero/Documents/JetbrainsAcademy/" +
                "JavaDeveloperTrack/PhoneBook/TestFiles/FilesTraversal01/file2.txt");
        System.out.println(areSibilings(file1, file2));

    }

    public static void printAllFiles(File file) {
        File[] files = file.listFiles();
        for (File i : files) {
            System.out.println(i.getName());
        }
    }

    public static boolean areSibilings(File file1, File file2) {
        return file1.getParent().equals(file2.getParent());
    }
}
