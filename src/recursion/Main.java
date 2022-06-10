package recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(pow(2, 5));

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

    public static int sumFirstN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumFirstN(n - 1);
        }
    }


    public static long method(long n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + method(n / 10);
    }

    // Fibonacci
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    // N-th power using recursion
    public static double pow(double a, long n) {
        if (a == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double y;
        if (n % 2 == 0) {
            y = pow(a, n / 2);
            y = y * y;
        } else {
            y = a;
            y = y * pow(a, n - 1);
        }

        return y;
    }
}
