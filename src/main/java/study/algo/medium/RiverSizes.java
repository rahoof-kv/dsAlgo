package study.algo.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 1, 1},
                {0, 0, 0},
                {1, 0, 1}
        };



        List<Integer> list = getRiverSizes(matrix);
        System.out.println(list);
        display(matrix);
    }

    private static List<Integer> getRiverSizes(int[][] matrix) {
        List<Integer> riverSizeList = new ArrayList<>();
        boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visitedMatrix[i][j]) {
                    continue;
                }
                traverseMatrix(matrix, visitedMatrix, riverSizeList, i, j);
            }
        }

        return riverSizeList;
    }

    private static void traverseMatrix(int[][] matrix, boolean[][] visitedMatrix, List<Integer> riverSizeList, int i, int j) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        int currentSize = 0;

        while (!stack.isEmpty()) {

            int[] node = stack.pop();
            i = node[0];
            j = node[1];

            if(visitedMatrix[i][j]){
                continue;
            }

            visitedMatrix[i][j] = true;

            if(matrix[i][j] == 0){
                continue;
            }
            currentSize++;
            List<int[]> unVistedNodes = getUnvistedNodes(i, j, matrix,visitedMatrix);

            for (int[] unVistedNode: unVistedNodes){
                stack.add(unVistedNode);
            }
        }
        if(currentSize > 0){
            riverSizeList.add(currentSize);
        }

    }

    private static List<int[]> getUnvistedNodes(int i, int j,  int[][] matrix, boolean[][] visitedMatrix) {
        List<int[]> unVistedNodes = new ArrayList<>();

        if(i> 0 && !visitedMatrix[i-1][j]){
            unVistedNodes.add(new int[]{i-1,j});
        }

        if(i< matrix.length -1 && !visitedMatrix[i+1][j]){
            unVistedNodes.add(new int[]{i+1,j});
        }

        if(j> 0 && !visitedMatrix[i][j-1]){
            unVistedNodes.add(new int[]{i,j-1});
        }

        if(j< matrix.length -1 && !visitedMatrix[i][j+1]){
            unVistedNodes.add(new int[]{i,j+1});
        }

        return unVistedNodes;
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
