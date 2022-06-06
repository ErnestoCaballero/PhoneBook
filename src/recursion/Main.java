package recursion;

public class Main {
    public static void main(String[] args) {

    }

    // Check if a float number is power of two recursively
    public static boolean isPowerOfTwo(float x) {
        if (x == 1) {
            return true;
        } else {
            if (x % 2 == 0) {
                return isPowerOfTwo(x / 2);
            } else {
                return false;
            }
        }
    }
}
