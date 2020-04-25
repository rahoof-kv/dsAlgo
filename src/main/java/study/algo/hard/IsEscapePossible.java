package study.algo.hard;

import java.util.*;

public class IsEscapePossible {

    //Input: blocked = [], source = [0,0], target = [999999,999999]
    public static void main(String[] args) {

        System.out.println(isEscapePossible(new int[][]{{0,1}}, new int[]{0,0}, new int[]{5,5}));
    }
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {


        boolean[][] visited = new boolean[target[0]][target[1]];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        visited[source[0]][source[1]] = true;

        int nodesLeftInLayer = 1;
        int nodesInNextLayer = 0;
        int moveCount = 0;
        Set<int[]> blockedSet = new HashSet<>();
        for (int[] block: blocked ) {
            blockedSet.add(block);
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            //for (int k = 0; k < size; k++) {
                int[] currentNode = queue.poll();

                int i = currentNode[0];
                int j = currentNode[1];
               /* if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;*/
                System.out.println(i +" "+ j);
                if (target[0] - 1 == i && target[1] -1 == j) {
                    System.out.println("move count:" + moveCount);
                    return true;
                }

                nodesLeftInLayer--;
                List<int[]> neighbourList = getNeighbours(i, j, visited, blockedSet, nodesInNextLayer);
                for (int[] neighbour: neighbourList) {
                    queue.offer(neighbour);
                }


                if(nodesLeftInLayer == 0) {
                    nodesLeftInLayer = nodesInNextLayer;
                    nodesInNextLayer = 0;
                    moveCount++;
                }

            //}

        }

        return false;

    }

    private static List<int[]> getNeighbours(int i , int j, boolean[][] visited, Set<int[]> blockedSet, int nodesInNextLayer) {

        List<int[]> neighbourList = new ArrayList<>();
        if (i-1 >= 0 ) {
            int[] pos = new int[]{i-1,j};
            if (!blockedSet.contains(pos) && !visited[i-1][j]){
                visited[i-1][j] = true;
                neighbourList.add(pos);
                nodesInNextLayer++;
            }
        }

        if (i +1  < visited.length && !visited[i+1][j] ) {
            int[] pos = new int[]{i+1,j};
            if (!blockedSet.contains(pos)){
                visited[i+1][j] = true;
                neighbourList.add(pos);
                nodesInNextLayer++;
            }

        }

        if (j -1 >= 0 && !visited[i][j-1]) {
            int[] pos = new int[]{i,j-1};
            if (!blockedSet.contains(pos)){
                visited[i][j-1] = true;
                neighbourList.add(pos);
                nodesInNextLayer++;
            }

        }

        if (j +1 < visited[0].length && !visited[i][j+1] ) {
            int[] pos = new int[]{i,j+1};
            if (!blockedSet.contains(pos)){
                visited[i][j+1] = true;
                neighbourList.add(pos);
                nodesInNextLayer++;
            }

        }


        return neighbourList;
    }
}
