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

        File directory = new File("/Users/ernestocaballero/Desktop/FilesClassJava");
        printAllFiles(directory);

    }

    public static void printAllFiles(File file) {
        File[] files = file.listFiles();
        for (File i : files) {
            System.out.println(i.getName());
        }
    }
}
