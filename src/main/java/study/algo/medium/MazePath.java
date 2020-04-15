package study.algo.medium;

import java.util.*;

public class MazePath {

    public static void main(String[] args) {

       int matrix[][] = {
                {1, 1, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
        };

  /*      int[][] matrix = {
                {1, 1,1, 1,1},
                {1, 0,0, 0,1},
                {1, 0,0, 0,1},
                {1, 1,0, 0,1},
                {0, 1,0, 0,1},
                {0, 1,1, 1,1}
        };*/

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        printMatrix(matrix);

        traceMazeHelper(matrix, visited);

        printVisted(visited);
    }

    private static void printVisted(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();

        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }
    }

    private static void traceMazeHelper(int[][] matrix, boolean[][] visited) {
        List<List<int[]>> AllVisitedNodes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                dfs(matrix, visited, i, j,AllVisitedNodes);
            }
        }

        List<int[]> visitedNodes = AllVisitedNodes.get(0);
        visitedNodes.stream().forEach(val ->  System.out.println(val[0] +" , " + val[1]));

    }

    private static boolean dfs(int[][] matrix, boolean[][] visited, int i, int j, List<List<int[]>> allVisitedNodes) {
        List<int[]> visitedNodes = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        boolean isReached = false;
        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            int i1 = node[0];
            int j1 = node[1];

            if (i1 == matrix.length -1 && j1 == matrix[0].length-1) {
                System.out.println("break");
                //isReached = true;
                break;
            }

            if(visited[i1][j1]){
                continue;
            }

            visited[i1][j1] = true;

            if(matrix[i1][j1] == 0){
                continue;
            }
            //System.out.println("i1:" + i1 +" "+ "j1:"+ j1);
            visitedNodes.add(new int[]{i1,j1});

            List<int[]> neighbouringNodes = getNeighbouringNodes(visited, i1, j1);
            if (!neighbouringNodes.isEmpty()) {
                neighbouringNodes.stream().forEach(val -> stack.push(val));
            }

        }

        if(!allVisitedNodes.isEmpty()) {
           List<int[]> existingNodes = allVisitedNodes.get(0);
           if(!visitedNodes.isEmpty() && visitedNodes.size() >= existingNodes.size()){
               allVisitedNodes.remove(0);
               allVisitedNodes.add(visitedNodes);
           }

        } else {
            if(!visitedNodes.isEmpty()) {
                allVisitedNodes.add(visitedNodes);
            }
        }

        return isReached;
    }

    private static List<int[]> getNeighbouringNodes(boolean[][] visited, int i, int j) {
        List<int[]> unVistedNodes = new ArrayList<>();

        if(i> 0 && visited[i-1][j] == false){
            unVistedNodes.add(new int[]{i-1,j});
        }

        if(i< visited.length -1 && visited[i+1][j] == false){
            unVistedNodes.add(new int[]{i+1,j});
        }

        if(j> 0 && visited[i][j-1] == false){
            unVistedNodes.add(new int[]{i,j-1});
        }

        if(j< visited[0].length -1 && visited[i][j+1] == false){
            unVistedNodes.add(new int[]{i,j+1});
        }

        return unVistedNodes;
    }


}
