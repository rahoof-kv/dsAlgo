package study.algo.easy;


public class LeafSum {

    static int total = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        leafSum(root);
        System.out.println(total);
    }

    public static void leafSum(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            leafSum(root.left);
        }

        if (root.right != null) {
            leafSum(root.right);
        }

        if (root.left == null && root.right == null) {
            total += root.val;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
