package study.algo.medium;

import java.util.Arrays;

public class MinNumberOfCoinFOrChange {

    public static void main(String[] args) {
        int[] input = {1, 2};
        System.out.println(minNumberOfCoinsForChange(3, input));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] numOfCoins = new int[n+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare = 0;
        for (int denom: denoms) {
            for (int amount = 1; amount < n+1 ; amount++) {
                if (denom <= amount) {
                    if (numOfCoins[amount- denom] == Integer.MAX_VALUE){
                        toCompare = numOfCoins[amount- denom];
                    } else {
                        toCompare = numOfCoins[amount- denom] + 1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount] , toCompare);
                }
            }
        }
        return numOfCoins[n] != Integer.MAX_VALUE ?  numOfCoins[n]: -1;
    }
}


/*
class Program {
    public static int getNthFib(int n) {

        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        }else {
            int[] fib = new int[n+1];
            fib[0] = 0;
            fib[1] = 1;
            fib[2] = fib[1]+ fib[0];

            for(int i = 3; i <=n ; i++) {
                fib[i] = fib[i-2] + fib[i-1];
            }
            return fib[n+1];
        }

    }*/

