package study.algo.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }

    public static String reorganizeString(String S) {

        // build countmap
        Map<Character, Integer> counts = new HashMap<>();
        for (char character : S.toCharArray()) {
            counts.put(character, counts.getOrDefault(character,0)+1);
        }

        //place it in max heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        //Build string by taking from maxheap based on the count
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {

            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current);
            result.append(next);

            //update count
            counts.put(current, counts.get(current) -1);
            counts.put(next, counts.get(next) - 1);

            //place back in maxHeap is count > 0
            if (counts.get(current) > 0) {
                maxHeap.add(current);
            }

            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1) {
                return "";
            }
            result.append(last);
        }


        return result.toString();
    }


}
