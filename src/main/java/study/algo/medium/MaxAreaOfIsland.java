package study.algo.medium;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 1, 1},
                {1, 0, 0},
                {0, 1, 1}
        };

       /* int matrix[][] = {
                {1, 1,}
            };
        */

        int count = maxAreaOfIsland(matrix);
        System.out.println(count);
        display(matrix);
    }


    private static int maxAreaOfIsland(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    max = Math.max(max, dfs(matrix, i, j));
                }

            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0) {
            return 0;
        }

        matrix[i][j] = 0;
        int count = 1;
        count += dfs(matrix, i + 1, j);
        count += dfs(matrix, i, j + 1);
        count += dfs(matrix, i - 1, j);
        count += dfs(matrix, i, j - 1);
        return count;
    }


    public static void display(int matrix[][]) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                System.out.print(matrix[y][x] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("======================");

    }
}
