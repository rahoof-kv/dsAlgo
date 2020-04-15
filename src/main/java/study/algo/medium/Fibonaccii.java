package study.algo.medium;

public class Fibonaccii {

    public static void main(String[] args) {

        System.out.println(getNthFib(8));
    }

    public static int getNthFib(int n) {
        if (n == 1){
            return 0;
        } else if (n == 2){
            return 1;
        } else {
            int[] fib = new int[n+1];
            fib[0] = 0;
            fib[1] = 1;
            fib[2] = 1;
            for(int i = 3; i <=n ; i++) {
                fib[i] = fib[i-2] + fib[i-1];
            }
            return fib[n-1];
        }

    }
}
