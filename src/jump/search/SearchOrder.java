package jump.search;

public class SearchOrder {

    public static void main(String[] args) {
        int[] arr = new int[101];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int[] toFind = {1, 2, 10, 11, 12, 20, 32};

        for (int i : toFind) {
            int[] result = myJumpSearch(arr, i);
            System.out.printf("Value searched: %d | Index: %d | Comparisons: %d%n", i, result[0], result[1]);
        }


    }

    public static int[] myJumpSearch(int[] arr, int value) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int[] result = new int[2];
        int curr = 0;
        int comparisons = 0;

        while (curr < arr.length) {
            if (arr[curr] == value) {
                comparisons++;
                result[0] = curr;
                result[1] = comparisons;
                return result;
            } else if (arr[curr] < value) {
                comparisons++;
                if (curr + step >= arr.length) {
                    // Check last block
                    for (int i = curr; i < arr.length; i++) {
                        if (arr[i] == value) {
                            result[0] = curr;
                            result[1] = comparisons;
                            return result;
                        }
                        curr++;
                    }
                    result[0] = -1;
                    result[1] = comparisons;
                    return result;
                } else {
                    curr += step;
                }
            } else {
                // arr[curr] > value case
                comparisons++;
                for (int i = curr - 1; i > curr - step; i--) {

                    comparisons++;
                    if (i < 0) {
                        result[0] = -1;
                        result[1] = comparisons;
                        return result;
                    }
                    if (arr[i] == value) {
                        result[0] = i;
                        result[1] = comparisons;
                        return result;
                    }
                }

                result[0] = -1;
                result[1] = comparisons;
                return result;
            }
        }

        result[0] = -1;
        result[1] = comparisons;
        return result;
    }
}
