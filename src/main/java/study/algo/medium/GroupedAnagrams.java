package study.algo.medium;

import java.util.*;

public class GroupedAnagrams {

    public static void main(String[] args) {

        String[] data = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(data);

        System.out.println(result.toString());

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);

            String sortedString = new String(characters);

            if (!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new ArrayList<>());
            }

            anagramMap.get(sortedString).add(str);

        }
        return new ArrayList<>(anagramMap.values());
    }


}
