package jump.search;

public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 13, 19, 20, 24, 26, 30, 34, 37};
        int value = 36;

//        System.out.println(jumpSearch(arr, value));
        System.out.printf("Result %d", myJumpSearch(arr, value));

    }

    public static int myJumpSearch(int[] arr, int value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        System.out.println("Step = " + step);

        int curr = 0;
        int iteration = 0;

        while (curr < arr.length) {
            System.out.printf("Enter while | curr = %d | Iteration = %d | arr[curr] = %d%n", curr, iteration, arr[curr]);

            if (arr[curr] == value) {
                System.out.printf("Enter arr[%d] == %d%n", curr, value);
                return curr;
            } else if (arr[curr] < value /*&& curr < arr.length - step*/) {
                System.out.printf("Enter arr[%d](%d) < %d%n", curr, arr[curr], value);
                if (curr + step >= arr.length) {
                    System.out.println("ENTER | curr = " + curr);
                    // Check last block
                    for (int i = curr; i < arr.length; i++) {
                        System.out.printf("\tfor i = %d | arr[%d](%d) == %d\n", i, i, arr[i], value);
                        if (arr[i] == value) {
                            return curr;
                        }
                        curr++;
                    }
                    return -1;
                } else {
                    System.out.println("ENTER 2 " + (curr + step));
                    curr += step;
                }
            } else if (arr[curr] > value) {
                System.out.printf("Enter arr[%d](%d) > %d%n", curr, arr[curr], value);
                for (int i = curr - 1; i > curr - step; i--) {
                    if (i < 0) {
                        return -1;
                    }

                    if (arr[i] == value) {
                        return i;
                    }
                }
                return -1;
            } else {
                break;
            }

            iteration++;
        }

        return -1;
    }

    public static int jumpSearch(int[] arr, int value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));

        int curr = 0;

        while (curr < arr.length) {
            if (arr[curr] == value) {
                return curr;
            } else if (arr[curr] > value) {
                int ind = curr - 1;
                while (ind > curr - step && ind >= 1) {
                    if (arr[ind] == value) {
                        return ind;
                    }
                    ind--;
                }
                return -1;
            }
            curr += step;
        }

        int ind = arr.length;

        while (ind > curr - step) {
            if (arr[ind] == value) {
                return ind;
            }
            ind--;
        }

        return -1;
    }
}
