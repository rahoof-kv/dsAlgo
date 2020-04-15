package study.algo.easy;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(10,input));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {

        int[] numOfCoins = new int[n + 1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare;
        for (int denom : denoms) {
            for (int amount = 0; amount < n + 1; amount++) {
                if (denom <= amount) {
                    //if(numOfCoins[amount-denom] ==  Integer.MAX_VALUE) {
                   //     toCompare = numOfCoins[amount-denom];
                   // } else {
                      //  toCompare = 1+ numOfCoins[amount-denom];
                   // }
                    numOfCoins[amount] = Math.min(numOfCoins[amount],1+ numOfCoins[amount-denom]);
                }
            }
        }

        return numOfCoins[n] == Integer.MAX_VALUE ? -1 : numOfCoins[n];
    }
}
