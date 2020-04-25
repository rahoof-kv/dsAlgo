package study.algo.medium;

import java.util.PriorityQueue;

public class ConnectSticks {

    public static void main(String[] args) {

        // 1+ 3 = 4
        // 4 + 5 = 9
        //  9 + 8 = 17
        System.out.println(connectSticks(new int[]{1, 3, 5, 8}));

    }

    public static int connectSticks(int[] sticks) {

      /*  Arrays.sort(sticks);
        int stickLength = 0;
        int totalStickLength = 0;
        for (int i = 0; i < sticks.length -1 ; i++) {
            stickLength = sticks[i] + sticks[i+1];
            sticks[i+1] = stickLength;
            totalStickLength += sticks[i+1];
        }
        return totalStickLength;*/

        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            minHeap.add(stick);
        }

        while (!minHeap.isEmpty()) {

            if (minHeap.size() == 1) {
                break;
            }

            int firstStick = minHeap.remove();
            int nextStick = minHeap.remove();

            int sum = firstStick + nextStick;
            cost += sum;
            minHeap.add(sum);
        }

        return cost;

    }
}
