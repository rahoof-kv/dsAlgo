package study.algo.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLables(S);
        System.out.println(result.toString());
    }

    public static List<Integer> partitionLables(String S) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastSeenIndices = new int[26];
        for (int i = 0; i < S.length() ; i++) {
            lastSeenIndices[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < S.length()) {
            int end = lastSeenIndices[S.charAt(i) - 'a'];
            int j = i;
            while (j != end) {
                end = Math.max(end, lastSeenIndices[S.charAt(j++) - 'a']);
            }
            partitionLengths.add(j -i +1);
            i = j+1;
        }
        return partitionLengths;
    }
}
