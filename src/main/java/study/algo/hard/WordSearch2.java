package study.algo.hard;

import java.util.*;

public class WordSearch2 {


    public static void main(String[] args) {
        //board = [
        //  ['o','a','a','n'],
        //  ['e','t','a','e'],
        //  ['i','h','k','r'],
        //  ['i','f','l','v']
        //]
        //words = ["oath","pea","eat","rain"]
        //Output: ["eat","oath"]

       /* char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        */

        char[][] board = {
                {'a', 'a'}
        };

        String[] words = new String[]{"a"};
        List<String> result = findWords(board, words);
        System.out.println(result.toString());
    }

    public static List<String> findWords(char[][] board, String[] words) {

        //Push all words to trie ds
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        //search for the  word
        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                searchWord(i, j, finalWords, board, visited, trie.root);
            }
        }
        return new ArrayList<>(finalWords);
    }

    private static void searchWord(int i, int j, Set<String> finalWords, char[][] board, boolean[][] visited, TrieNode trieNode) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        char letter = board[i][j];

        if (!trieNode.children.containsKey(letter)) {
            return;
        }

        trieNode = trieNode.children.get(letter);
        if (trieNode.isWord) {
            finalWords.add(trieNode.word);
        }

        visited[i][j] = true;

        searchWord(i, j+1, finalWords, board, visited, trieNode);
        searchWord(i, j-1, finalWords, board, visited, trieNode);
        searchWord(i+1, j, finalWords, board, visited, trieNode);
        searchWord(i-1, j, finalWords, board, visited, trieNode);

        //visited[i][j] = false;

    }


    static class TrieNode {
        Map<Character,TrieNode> children =  new TreeMap<>();
        String word = "";
        boolean isWord = false;
    }

    static class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void add(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.word = word;
            node.isWord = true;
        }
    }
}
