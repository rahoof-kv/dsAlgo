package study.algo.medium;

import java.util.ArrayList;
import java.util.List;

class KnapSackProblem {

    public static void main(String[] args) {
        // int[][] expected = {{10}, {1, 3}};
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        System.out.println(knapsackProblem(input,10));

    }
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {

        int[][] knapSackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < items.length + 1; i++) {
            int currentValue = items[i - 1][0];
            int currentWeight = items[i - 1][1];
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {
                    knapSackValues[i][c] = knapSackValues[i - 1][c];
                } else {
                    knapSackValues[i][c] =
                            Math.max(
                                    knapSackValues[i - 1][c],
                                    knapSackValues[i - 1][c - currentWeight] + currentValue);
                }
            }
        }

        return getKnapSackItems(items, knapSackValues, knapSackValues[items.length][capacity]);
    }

    private static List<List<Integer>> getKnapSackItems(int[][] items, int[][] knapSackValues, int weight) {

        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();
        totalWeight.add(weight);

        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());

        int i = knapSackValues.length - 1;
        int c = knapSackValues[0].length - 1;

        while (i > 0) {

            if (knapSackValues[i][c] == knapSackValues[i - 1][c]) {
                i--;
            } else {
                sequence.get(1).add(0, i - 1);

                c -= items[i - 1][1];
                System.out.println(items[i - 1][1]+" "+ items[i - 1][0]);
                i--;

            }

            if (c == 0) {
                break;
            }
        }

        return sequence;
    }
}
