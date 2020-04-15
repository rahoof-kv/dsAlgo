package study.algo.medium;

public class WallGatesProblem {

    public static void main(String[] args) {


        int[][] rooms = {
                {10, -1, 0, 10},
                {10, 10, 10, -1},
                {10, -1, 10, -1},
                {0, -1, 10, 10}
        };

        display(rooms);

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }

            }
        }

        display(rooms);
    }

    private static void dfs(int[][] rooms, int i, int j, int count) {

        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || count > rooms[i][j]) {
            return;
        }
        rooms[i][j] = count;

        dfs(rooms, i + 1, j, count + 1);
        dfs(rooms, i - 1, j, count + 1);
        dfs(rooms, i, j + 1, count + 1);
        dfs(rooms, i, j - 1, count + 1);
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
