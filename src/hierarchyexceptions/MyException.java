package hierarchyexceptions;

/*
BASE CLASS
Create a class named MyException, which must inherit from the base class for all exceptions and errors.
Inside the MyException class declare a constructor that takes String message as an argument and passes the message to the superclass.
 */

public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

}
