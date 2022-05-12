package com.ernesto;

public class TestClass {

    public static void main(String[] args) {

        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        long end = System.currentTimeMillis();
        long lapse = end - start;

        long minutes = lapse / 1_000 / 60;
        long seconds = (lapse / 1_000) % 60;
        long ms = lapse % 1000;
//        double ms = lapse - (minutes * 60 * 1_000) - (seconds * 1_000 + ()
        System.out.println("Minutes: " + minutes + " | seconds: " + seconds  + " | ms: " + ms);

        System.out.println(end - start);
        System.out.println(lapse);

        System.out.println();

        long time = 125_301;
        long minutes1 = time / 1_000 / 60;
        long seconds1 = (time / 1_000) % 60;
        long ms1 = time % 1000;
        System.out.println("Minutes: " + minutes1 + " | seconds: " + seconds1  + " | ms: " + ms1);


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
