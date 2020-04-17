package study.algo.medium;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},

        };


        boolean result = exist(board, "ABCCED");

        System.out.println(result);

    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, int count, char[][] board, String word) {

        if (word.length() == count) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found =
                dfs(i + 1, j, count + 1, board, word)
                        || dfs(i, j + 1, count + 1, board, word)
                        || dfs(i - 1, j, count + 1, board, word)
                        || dfs(i, j - 1, count + 1, board, word);

        board[i][j] = temp;

        return found;
    }
}
