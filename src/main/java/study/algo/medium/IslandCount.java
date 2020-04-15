package study.algo.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IslandCount {


    public static void main(String[] args) {
        char[][] grid = {
                {'1','1', '1'},
                {'0','1', '0'},
                {'1','1', '1'},
        };

        display(grid);

        List<Integer> islandList = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        displayVisited(visited);
        getIslandCount(islandList, visited, grid);
        displayVisited(visited);
        islandList.stream().forEach(island -> System.out.println(island));

        System.out.println(islandList.size());

    }


    private static void getIslandCount(List<Integer> count, boolean[][] visited, char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!visited[i][j]) {
                    dfs(count, visited, grid, i, j);
                }
            }
        }
    }

    private static void dfs(List<Integer> count, boolean[][] visited, char[][] grid, int i, int j) {

        int[] position = new int[]{i, j};
        Stack<int[]> stack = new Stack<>();
        stack.push(position);

        int currentSize = 0;
        while (!stack.isEmpty()) {

            int[] node = stack.pop();
            int i1 = node[0];
            int j1 = node[1];

            if (visited[i1][j1]) {
                continue;
            }

            //mark as visited
            visited[i1][j1] = true;

            if (grid[i1][j1] == '0') {
                continue;
            }

            currentSize++;

            List<int[]> neighboringNodes = getNeighbouringNodes(visited, i1, j1);

            if (!neighboringNodes.isEmpty()) {
                neighboringNodes.stream().forEach(item -> stack.push(item));
            }

        }
        if (currentSize > 0) {
            count.add(currentSize);
        }

    }

    private static List<int[]> getNeighbouringNodes(boolean[][] visited, int i1, int j1) {
        List<int[]> neighbouringNodes = new ArrayList<>();

        if (j1 + 1 < visited[0].length && !visited[i1][j1 + 1]) {
            neighbouringNodes.add(new int[]{i1, j1 + 1});
        }

        if (i1 + 1 < visited.length && !visited[i1 + 1][j1]) {
            neighbouringNodes.add(new int[]{i1 + 1, j1});
        }

        if (i1 > 0 && !visited[i1 - 1][j1]) {
            neighbouringNodes.add(new int[]{i1 - 1, j1});
        }

        if (j1 > 0 && !visited[i1][j1 - 1]) {
            neighbouringNodes.add(new int[]{i1, j1 - 1});
        }
        return neighbouringNodes;
    }

    public static void display(char[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("======================");

    }

    public static void displayVisited(boolean[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("======================");

    }
}
