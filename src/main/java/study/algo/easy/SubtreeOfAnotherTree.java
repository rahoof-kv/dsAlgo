package study.algo.easy;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
/*
     3
    / \
   4   5
  / \
 1   2

  4
  / \
 1   2

* */

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(isSubtree(s,t));

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        } else if (isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    private static boolean isSameTree(TreeNode s, TreeNode t) {

        if (s == null || t == null) {
            return s == null && t == null;
        } else if (s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else {
            return false;
        }
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
