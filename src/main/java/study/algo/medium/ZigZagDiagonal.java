package study.algo.medium;


public class ZigZagDiagonal {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };

        int row = 0;
        int col = 0;
        int height = matrix.length - 1;
        int width = matrix[0].length - 1;
        boolean isGoingDown = true;

        while (!isOutOfBound(row, col, height, width)) {
            System.out.print(matrix[row][col]+" ");

            if (isGoingDown) {
                if (col == 0 || row == height) {
                    isGoingDown = false;
                    if (row == height) {
                        col++;
                        System.out.println();
                    } else {
                        row++;
                        System.out.println();

                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    isGoingDown = true;
                    if (col == width) {
                        row++;
                        System.out.println();
                    } else {
                        col++;
                        System.out.println();
                    }
                } else {
                    col++;
                    row--;
                }
            }
        }

    }

    private static boolean isOutOfBound(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }


}
