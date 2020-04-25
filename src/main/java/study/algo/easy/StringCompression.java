package study.algo.easy;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    public static void main(String[] args) {
        char[] input = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(compress(input));
    }

    public static int compress(char[] chars) {

        int i = 0;
        int index = 0;
        while (i < chars.length) {
            int j = i;
            char letter = chars[i];
            while (j < chars.length && chars[j] == letter) {
                j++;
            }

            chars[index++] = chars[i];
            if (j - i > 1) {
                String countStr = j - i +"";
                for (char c: countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }

            i = j++;

        }

        return index;

    }
}
