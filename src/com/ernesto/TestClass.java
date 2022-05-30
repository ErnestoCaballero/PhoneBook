package com.ernesto;

import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        String[] currArr = "45073498 Celestina Orren".split(" ");
        String[] nextArr = "30781414 Esofea".split(" ");
        System.out.println(currArr.length);
        System.out.println(nextArr.length);




    }

    public static boolean isAlphabetical(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1].compareTo(arr[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static String[] removeElementFromArray(String[] toReplace, String toRemove) {
        boolean contains = false;

        for (String s : toReplace) {
            if (s.equals(toRemove)) {
                contains = true;
            }
        }

        if (!contains) {
            System.out.println("The element doesn't exist in the Array!\nReturning original Array");
            return toReplace;
        }

        String[] result = new String[toReplace.length - 1];

        for (int i = 0; i < toReplace.length - 1; i++) {
            if (!toReplace[i].equals(toRemove)) {
                result[i] = toReplace[i];
            } else {
                for (int j = i; j < toReplace.length - 1; j++) {
                    result[j] = toReplace[j + 1];
                }
                break;
            }
        }

        result[result.length - 1] = toReplace[toReplace.length - 1];

        return result;
    }
}
