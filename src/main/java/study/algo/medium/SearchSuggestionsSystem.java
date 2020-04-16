package study.algo.medium;

import java.util.*;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> suggestedProducts = suggestedProducts(products, searchWord);
        System.out.println(suggestedProducts.toString());

    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        SuffixTrie trie = new SuffixTrie();
        for (String product : products) {
            trie.populateSuffixTrie(product);
        }

        List<List<String>> allProductList = new ArrayList<>();
        for(int i = 0 ; i < searchWord.length() ; i++){
            List<String> matchProducts = new ArrayList<>();
            getSuggestedProducts(searchWord.substring(0,i+1), matchProducts, trie);
            allProductList.add(matchProducts);
        }

        return allProductList;

    }

    public static void getSuggestedProducts(String word, List<String> matchProducts, SuffixTrie trie){

        TrieNode curr = trie.root;
        for(int i = 0 ; i < word.length() ;i++){
            char c = word.charAt(i);
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            }else{
                return;
            }
        }

        dfs(curr, matchProducts);
    }

    private static void dfs(TrieNode curr, List<String> matchWords) {

        if (curr == null) {
            return;
        }

        if (matchWords.size() == 3) {
            return;
        }

        if(curr.isWord){
            matchWords.add(curr.word);
        }
        // recursively call for dfs for very children of curr node
        for(TrieNode node : curr.children.values()){
            dfs(node, matchWords);
        }
    }


    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        String word = "";
        boolean isWord;
    }

    static class SuffixTrie {
        TrieNode root;
        Character endSymbol;

        public SuffixTrie() {
            root = new TrieNode();
            endSymbol = '*';
        }


        private void populateSuffixTrie(String str) {
            TrieNode node = root;
            for (int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
            node.word = str;
            node.isWord = true;
        }

    }
}
