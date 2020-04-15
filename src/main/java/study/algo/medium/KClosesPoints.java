package study.algo.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosesPoints {

    /*
    [[1,3],[-2,2]]
    1
    [[-2,2]]

    * */
    public static void main(String[] args) {
        int[][] result = kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[0] * a[1])));

        for (int i = 0; i < points.length; i++) {
            maxHeap.add(points[i]);
            if (maxHeap.size() > K) {
                maxHeap.remove();
            }
        }

        int[][] result = new int[K][2];
        while (K-- > 0) {
            result[K] = maxHeap.remove();
        }

        return result;

    }
}
