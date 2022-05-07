package com.ernesto;

import superkey.Developer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(File.separator);
        System.out.println(Integer.MAX_VALUE);
    }

    public static void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file1.txt"));
    }
}
