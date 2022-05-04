package hierarchyexceptions;

public class Main {

    public static void main(String[] args) {
//        MyException myException = new MyException("This is a custom exception");
//        System.out.println(myException.getMessage());
//        Class<?> superClass = myException.getClass().getSuperclass();
//        System.out.println(superClass.equals(Throwable.class));
//
//        printNumber();

        System.out.println(convertStringToDouble("100db"));


    }

    public static void printNumber() {
        MyException anotherException = new MyException(8, "Custom Exception message");
        System.out.printf("The number inside the object anotherException is; %d", anotherException.getA());
    }

    /*
    STRING TO DOUBLE CONVERSION
    Consider a method that takes a string and converts it to a double.
    If the input string happens to be null or of an unsuitable format, a runtime exception occurs and the program fails.

    Fix the method so it would catch any exception and return the default value 0 (zero) if an exception occurred.
     */

    public static double convertStringToDouble(String input) {
        double result;

        try {
            result = Double.parseDouble(input);
        } catch (RuntimeException e) {
            result = 0;
        }

        return result;
    }
}
