package study.algo.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {

    public static void main(String[] args) {

        Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(minMeetingRooms(intervals));
    }


    public static int minMeetingRooms(Interval[] intervals) {
        if(intervals == null ||intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals,(a,b) -> a.start - b.start);

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        minHeap.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval current = intervals[i];
            Interval earliest = minHeap.remove();
            if(current.start >= earliest.end) {
                earliest.end = current.end;
            } else{
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }

        return minHeap.size();

    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
