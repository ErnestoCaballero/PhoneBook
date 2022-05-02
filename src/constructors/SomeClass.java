package constructors;


/*
    ENTANGLEMENT
    The class SomeClass has four constructors as shown below

    You've created an instance of this class:

    SomeClass instance = new SomeClass(300, "another-value");

    Find the correct values of fields for this instance.

    ANS: val = 50, str = "some-value"
 */

public class SomeClass {

    int val = 50;
    String str = "default";

    public SomeClass() {
        this(100);
    }

    public SomeClass(int val) {
        val = val;
    }

    public SomeClass(String str) {
        this();
        this.str = "some-value";
    }

    public SomeClass(int val, String str) {
        this(str);
    }
}
