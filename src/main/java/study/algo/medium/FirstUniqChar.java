package study.algo.medium;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {


        Map<Character, Integer> uniqueCharMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (!uniqueCharMap.containsKey(letter)) {
                uniqueCharMap.put(letter, i);
            } else {
                uniqueCharMap.put(letter, -1);
            }

        }

        Integer minIndex = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : uniqueCharMap.entrySet()) {
            if (entry.getValue() > -1 && entry.getValue() < minIndex) {
                minIndex = entry.getValue();
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
