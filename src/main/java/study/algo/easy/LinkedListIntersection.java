package study.algo.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersection {

    public static void main(String[] args) {

        //[4,1,8,4,5]
        //[5,0,1,8,4,5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = null;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);
        headB.next.next.next.next.next.next = null;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> visitedSet = new HashSet<>();

        ListNode aNode = headA;
        while (aNode != null) {
            visitedSet.add(aNode);
            aNode = aNode.next;
        }

        ListNode bNode = headB;
        ListNode intersectionNode = null;
        while (bNode != null) {
            if (visitedSet.contains(bNode)) {
                return bNode;
            }
            bNode = bNode.next;
        }

        return intersectionNode;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
