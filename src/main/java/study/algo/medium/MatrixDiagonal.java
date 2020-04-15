package study.algo.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixDiagonal {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };

        display(matrix);

        bfs(matrix, 0, 0);


    }

    private static void bfs(int[][] matrix, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                row = node[0];
                col = node[1];

                System.out.print(matrix[row][col] + " ");
                List<int[]> neighbours = getNeighbours(row, col, matrix);
                neighbours.stream().forEach(neighbour -> queue.offer(neighbour));
            }
            System.out.println();

        }

    }

    private static List<int[]> getNeighbours(int row, int col, int[][] matrix) {
        List<int[]> neighbourList = new ArrayList<>();

        if (col + 1 < matrix[0].length && row == 0 ) {
            neighbourList.add(new int[]{row, col + 1});
        }

        if (row + 1 < matrix.length ) {
            neighbourList.add(new int[]{row + 1, col});
        }

        return neighbourList;
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
