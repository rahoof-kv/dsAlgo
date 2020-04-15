package study.algo.medium;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {

    public static void main(String[] args) {
     /*   int matrix[][] = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };*/

        int matrix[][] = {
                { 0 }
        };

        display(matrix);

        int count = orangesRotting(matrix);

        System.out.println("count "+ count);
        display(matrix);
    }


    public static int orangesRotting(int[][] grid) {

        if(grid.length == 0 ) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int cnt = 0;
        int res = 0;
        int empty = 0;
        int fresh = 0;
        for(int i =0 ; i< grid.length; i++) {
            for(int j =0 ; j< grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                    cnt ++;
                } else if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (empty > 0 && queue.size() == 0 & fresh == 0){
            return 0;
        }
        if (queue.size() == 0 && fresh == 0) {
            return -1;
        }
        target -= empty;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int size = queue.size();

            if(cnt == target) {
                return res;
            }

            for(int k =0 ; k< size; k++) {
                int[] node = queue.poll();
                for(int[] dir : dirs) {
                    int ni = node[0] + dir[0];
                    int nj = node[1] + dir[1];
                    if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 1) {
                        cnt++;
                        queue.offer(new int[] {ni, nj});
                        grid[ni][nj] = 2;
                    }
                }

            }
            res++;

        }

        return -1;
    }

    public static void display(int matrix[][]){
        System.out.println("======================");
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                System.out.print(matrix[y][x]);
            }
            System.out.print("\n");
        }
    }

}
