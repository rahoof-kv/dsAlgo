package study.algo.medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral {

    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        int[][] matrix = {
             //sC
           //sR
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
              //eR           //eC
        };


        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length -1;

        while (startRow <= endRow && startCol <= endCol) {


            for (int col = startCol; col <= endCol; col++) {
                System.out.println(matrix[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                System.out.println(matrix[row][endCol]);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                System.out.println(matrix[endRow][col]);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                System.out.println(matrix[row][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }


        result.stream().forEach(System.out::println);

    }
}
