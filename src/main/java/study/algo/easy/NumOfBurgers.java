package study.algo.easy;

import java.util.Arrays;

public class NumOfBurgers {

    public static void main(String[] args) {
        int[] result = numOfBurgers(1, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int[] result = new int[]{-1,-1};

        int count = cheeseSlices/2;

        int jumbo = count - tomatoSlices;

        if (jumbo >= 0 && cheeseSlices %2 == 0 && !(count - 2 * jumbo < 0)) {

            result[0] = count - 2 * jumbo;
            result[1] = jumbo;

        }

        return result;
    }
}
