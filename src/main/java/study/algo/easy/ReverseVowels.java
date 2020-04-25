package study.algo.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {

        char[] charArray = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int idx = 0;
        int jdx = s.length() -1;

        while (idx < jdx ) {

            while (idx < jdx && !vowels.contains(Character.toLowerCase(s.charAt(idx)))) {
                idx++;
            }

            while ( idx < jdx &&  !vowels.contains(Character.toLowerCase(s.charAt(jdx)))) {
                jdx--;
            }

            swapVowel(charArray, idx, jdx);
            idx ++;
            jdx --;

        }

        return new String(charArray);

    }

    private static void swapVowel(char[] s, int idx, int jdx) {
        char temp = s[idx];
        s[idx] = s[jdx];
        s[jdx] = temp;

    }
}
