package study.algo.easy;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1983","32"));
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int Idx = num1.length() -1;
        int Jdx = num2.length() -1;

        int carry = 0;

        while (Idx >= 0 || Jdx >= 0) {

            int sum = carry;

            if (Idx >= 0) {
                sum += num1.charAt(Idx--) - '0';
            }

            if (Jdx >= 0) {
                sum += num2.charAt(Jdx--) - '0';
            }

            result.append(sum % 10);
            carry = sum/10;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
