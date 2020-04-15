package study.algo.easy;

public class ReverseString {

    public static void main(String[] args) {

        String s = "hello";
        char[] rev = new char[s.length()];
        printString(0,s.toCharArray(),rev);

        System.out.println(rev);

    }

    private static void printString(int index, char[] s, char[] rev){

        if(index >= s.length ){
            return;
        }
        rev[index] = s[s.length - index - 1];

        printString(index+1,s, rev);

    }
}
