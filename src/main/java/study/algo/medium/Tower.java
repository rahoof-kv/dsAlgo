package study.algo.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Tower {

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 0, 0, 0 },
                { 0, 1, 0, 1 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
        };

        display(matrix);

        int count = minDays(matrix);

        System.out.println("count "+ count);
        display(matrix);

    }

    private static int minDays(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int cnt = 0, res = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[] {i,j});
                    cnt++;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            if(cnt == target)
                return res;
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
                        cnt++;
                        q.offer(new int[] {ni, nj});
                        grid[ni][nj] = 1;
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
            for (int x = 0; x < matrix.length; x++) {
                System.out.print(matrix[y][x]);
            }
            System.out.print("\n");
        }
    }
}
