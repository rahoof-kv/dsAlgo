package study.algo.medium;

import java.util.*;
import java.util.stream.Collectors;

/*
Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.

* */
public class FrequentlyMentionedKeyWords {

    public static void main(String[] args) {

        String[] keyWords = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = new String[]{
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",
        };

        List<String> result = getFrequentlyMentionedWords(keyWords, reviews, 2);
        for (String val: result) {
            System.out.println(val);
        }
    }

    private static List<String> getFrequentlyMentionedWords(String[] keyWords, String[] reviews, int k) {


        Map<String, Integer> wordMapCount = new HashMap<>();
        for(String keyWord : keyWords) {
            for (String review : reviews) {
                if (review.toLowerCase().contains(keyWord)){
                    wordMapCount.put(keyWord, wordMapCount.getOrDefault(keyWord,0)+1);
                }
            }
        }

        for(Map.Entry<String,Integer> count : wordMapCount.entrySet()){
            System.out.println(count.getKey() +" "+ count.getValue());
        }

        List<String> ls = new ArrayList<>(wordMapCount.keySet());
        Collections.sort(ls, (a,b)-> (wordMapCount.get(a)).equals(wordMapCount.get(b))?a.compareTo(b):wordMapCount.get(b)-wordMapCount.get(a));

        return ls.stream().limit(k).collect(Collectors.toList());

    }

}
