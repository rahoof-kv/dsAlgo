package study.algo.medium;

import java.util.*;

public class BoggleBoard {

    public static void main(String[] args) {
        char[][] board = {
                {'y', 'g', 'f', 'y', 'e', 'i'},
                {'c', 'o', 'r', 'p', 'o', 'u'},
                {'j', 'u', 'z', 's', 'e', 'l'},
                {'s', 'y', 'u', 'r', 'h', 'p'},
                {'e', 'a', 'e', 'g', 'n', 'd'},
                {'h', 'e', 'l', 's', 'a', 't'}

        };

        String[] words = new String[]{"yg", "sana", "at", "vomit", "yours", "help", "end", "been", "bed", "danger", "calm", "ok", "chaos", "complete", "rear", "going", "storm", "face", "epual", "dangerous"};


        List<String> result = boggleBoard(board, words);

        System.out.println(result.toString());

    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        //construct trie
        SuffixTrie trie = new SuffixTrie();
        for (String word : words) {
            trie.populateSuffixTrie(word);
        }

        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                traverseBoggleBoard(i, j, board, finalWords, visited, trie.root);
            }
        }

        return new ArrayList<>(finalWords);
    }

    private static void traverseBoggleBoard(int i, int j, char[][] board, Set<String> finalWords, boolean[][] visited, TrieNode trieNode) {

        if (visited[i][j]) {
            return;
        }

        char letter = board[i][j];

        if (!trieNode.children.containsKey(letter)) {
            return;
        }

        visited[i][j] = true;

        trieNode = trieNode.children.get(letter);

        if (trieNode.children.containsKey('*')) {
            finalWords.add(trieNode.word);
        }

        List<int[]> neighbourList = getNeighbourList(i, j, board);

        for (int[] neighbour : neighbourList) {
            traverseBoggleBoard(neighbour[0], neighbour[1], board, finalWords, visited, trieNode);
        }

        //reset the visited flag after individual exploration
        visited[i][j] = false;
    }

    private static List<int[]> getNeighbourList(int i, int j, char[][] board) {
        List<int[]> neighbourList = new ArrayList<>();

        if (i > 0 && j > 0) {
            neighbourList.add(new int[]{i - 1, j - 1});
        }

        if (i > 0 && j < board[0].length - 1) {
            neighbourList.add(new int[]{i - 1, j + 1});
        }

        if (i < board.length - 1 && j < board[0].length - 1) {
            neighbourList.add(new int[]{i + 1, j + 1});
        }


        if (i < board.length - 1 && j > 0) {
            neighbourList.add(new int[]{i + 1, j - 1});
        }


        if (i > 0) {
            neighbourList.add(new int[]{i - 1, j});
        }

        if (i < board.length - 1) {
            neighbourList.add(new int[]{i + 1, j});
        }

        if (j > 0) {
            neighbourList.add(new int[]{i, j - 1});
        }


        if (j < board[0].length - 1) {
            neighbourList.add(new int[]{i, j + 1});
        }

        return neighbourList;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = "";
    }

    static class SuffixTrie {
        TrieNode root;
        Character endSymbol;

        public SuffixTrie() {
            this.root = new TrieNode();
            this.endSymbol = '*';
            ;
        }


        private void populateSuffixTrie(String str) {
            TrieNode node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
            node.word = str;
        }

    }
}
