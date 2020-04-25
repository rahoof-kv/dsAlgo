package study.algo.easy;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {

    public static void main(String[] args) {

        TreeNode s = new TreeNode(10);
        s.left = new TreeNode(5);
        s.right = new TreeNode(15);
        s.left.left = new TreeNode(3);
        s.left.right = new TreeNode(7);
        s.right.right = new TreeNode(18);

        //   10
        //     5      15
        //   3    7       18
        System.out.println(rangeSumBST(s, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {

        int sum = 0;
        if (root == null) {
            return sum;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node.val >= L && node.val <= R) {
                sum += node.val;
            }

            if (node.left != null ){
                queue.offer(node.left);
            }

            if (node.right != null ){
                queue.offer(node.right);
            }

        }
        return sum;
    }


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
