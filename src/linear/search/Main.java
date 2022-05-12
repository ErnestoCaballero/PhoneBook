package linear.search;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {0, 4, 8, 0, 6, 1, 4, 8, 0, 7};
        int[] arr2 = {3, 2, 9, 0, 6, 9, 2, 2, 5, 7};

        System.out.println(countSteps(arr1, arr2));
    }

    static int countSteps(int[] toFind, int[] toCheck) {
        int steps = 0;

        for (int i = 0; i < toFind.length; i++) {
            for (int j : toCheck) {
                steps++;
                if (j == toFind[i]) {
                    break;
                }
            }
        }

        return steps;
    }

}
