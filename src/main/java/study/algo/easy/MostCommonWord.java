package study.algo.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {

        String paragraph = "Bob. hIt, baLl";
        String[] banned = new String[]{"bob,hit"};

        System.out.println(mostCommonWord(paragraph,banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        Map<String,Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i< banned.length; i++) {
            bannedSet.add(banned[i]);
        }

        String[] words = paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split(" ");

        for (int i =0 ; i< words.length ; i++) {
            if(!bannedSet.contains(words[i]) && !words[i].isEmpty()){
                wordCountMap.put(words[i], wordCountMap.getOrDefault(words[i],0)+1);
            }
        }

        Integer max = Integer.MIN_VALUE;
        String result = " ";
        for (Map.Entry<String,Integer> wordCount: wordCountMap.entrySet()) {

            if(wordCount.getValue() >= max) {
                max = wordCount.getValue();
                result = wordCount.getKey();
            }
        }

        return result;

    }

}
