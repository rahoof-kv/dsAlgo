package study.algo.easy;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}


        };

        display(image);

        fill(image, 2, 2, image[2][2], 2);

        display(image);
    }

    private static void fill(int[][] image, int sr, int sc, int colour, int newColor) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != colour) {
            return;
        }

        image[sr][sc] = newColor;

        fill(image, sr + 1, sc, colour, newColor);
        fill(image, sr, sc + 1, colour, newColor);
        fill(image, sr - 1, sc, colour, newColor);
        fill(image, sr, sc - 1, colour, newColor);
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
