package study.algo.medium;

import java.util.HashMap;
import java.util.Map;

public class MinDominoRotations {

    public static void main(String[] args) {

        //Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
        //Output: 2
        //[1,1,1,1,1,1,1,1]
        //[1,1,1,1,1,1,1,1]
        int[] A = new int[]{2,1,2,4,2,2};
        int[] B = new int[]{5,2,6,2,3,2};
       // minDominoRotations(A, B);
        System.out.println(minDominoRotations(A, B));

    }

    //[3,5,1,2,3]
    //[3,6,3,3,4]

    //[2,1,2,4,2,2]
    //[5,2,6,2,3,2]
    public static int minDominoRotations(int[] A, int[] B) {
        int minSwaps = Math.min(getMinSwaps(A[0], A, B), getMinSwaps(A[0], B, A));
        minSwaps = Math.min(minSwaps, getMinSwaps(B[0], A, B));
        minSwaps = Math.min(minSwaps, getMinSwaps(B[0], B, A));

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    private static int getMinSwaps(int target, int[] A, int[] B ) {
        int swapCount = 0;
        for (int i =0; i< A.length; i++) {
            if (A[i] != target &&  B[i] != target) {
                return Integer.MAX_VALUE;
            } else if (target != A[i]) {
                swapCount++;
            }

        }

        return swapCount;
    }
}
