package study.algo.medium;

public class MultiplyStrings {


    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {

        int len1 = num1.length();  int len2 = num2.length();
        int len = len1+len2;
        int [] result = new int[len];

        //Init the result int array
        for (int i=0 ; i < result.length ; i++) {
            result[i] = 0;
        }

        // Iterate the numbers from the reverse & multiply the digits & then sum them up
        for (int i = len1-1 ; i >= 0 ; i--) {
            int k = --len;
            for (int j = len2-1; j >= 0 ; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[k];

                //Mod % gives the remainder / carry
                result[k] = sum % 10;

                //Division gives the quotient
                result[k-1] = result[k-1] + (sum / 10);

                k--;
            }
        }

        StringBuilder str = new StringBuilder();
        for (int n : result) {
           str.append(n);
        }

        return str.toString();
    }
}
