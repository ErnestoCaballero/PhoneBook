package com.ernesto;

import superkey.Developer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(File.separator);
    }

    public static void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file1.txt"));
    }
}
