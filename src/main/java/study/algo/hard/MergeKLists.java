package study.algo.hard;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MergeKLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null){
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (!minHeap.isEmpty()){
            Integer value = minHeap.remove();
            head.next = new ListNode(value);
            head = head.next;
        }

        return dummy.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
