package study.algo.easy;

import java.util.HashMap;
import java.util.Map;

public class Memoization {

    static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {

        int result = fibonacii(1000);
        System.out.println(result);
    }

    private static int fibonacii(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }

        int result;
        if(n < 2){
            result = n;
        }else{
            result = fibonacii(n-1) + fibonacii(n-2);
        }
        map.put(n,result);

        return result;

    }
}
