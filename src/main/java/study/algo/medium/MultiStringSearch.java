package study.algo.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    public static void main(String[] args) {

        String bigString = "Mary goes to the shopping enter every week.";
        String[] smallStrings = new String[]{"to", "Mary", "centers", "shop", "shopping", "string", "kappa"};
        List<Boolean> result = multiStringSearch(bigString,smallStrings);
        System.out.println(result.toString());
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        List<Boolean> result = new ArrayList<>();
        SuffixTrie suffixTrie = new SuffixTrie();
        //populate suffixTrie
        String[] words = bigString.split(" ");
        for (String word : words) {
            suffixTrie.populateSuffixTrieFrom(word);
        }

        for (String smallString : smallStrings) {
            result.add(suffixTrie.contains(smallString));
        }

        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();

        Character endSymbol = '*';

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                populateSuffixTrie(i, str);
            }
        }

        private void populateSuffixTrie(int position, String str) {
            TrieNode node = this.root;
            for (int i = position; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(this.endSymbol);
        }

    }

}
