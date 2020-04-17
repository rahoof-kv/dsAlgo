package study.algo.easy;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 4};
        int[] result = sortArrayByParity(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortArrayByParity(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[index];
                A[index++] = A[i];
                A[i] = temp;
            }
        }

        return A;

    }
}
