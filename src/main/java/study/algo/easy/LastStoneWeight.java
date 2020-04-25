package study.algo.easy;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone :stones) {
            maxheap.add(stone);
        }

        while(!maxheap.isEmpty()) {

            if(maxheap.size() == 1) {
                break;
            }
            int stone1 = maxheap.remove();
            int stone2 = maxheap.remove();

            if (stone1 == stone2) {
                continue;
            }

            if (stone1 != stone2) {
                int newStone = stone1 > stone2 ? stone1-stone2 : stone2-stone1;
                maxheap.add(newStone);
            }

        }

        int lastStone = 0;
        if (!maxheap.isEmpty()) {
            lastStone = maxheap.remove();
        }

        return lastStone;

    }
}
