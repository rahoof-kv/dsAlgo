package study.algo.easy;

public class MaxDepth {

    public static void main(String[] args) {
        TreeNode binaryTree = new TreeNode(5);
        binaryTree.left = new TreeNode(4);
        binaryTree.right = new TreeNode(8);
        binaryTree.left.left = new TreeNode(11);
        binaryTree.left.left.left = new TreeNode(7);
        binaryTree.left.left.right = new TreeNode(2);

        binaryTree.right.left = new TreeNode(13);
        binaryTree.right.right = new TreeNode(4);

        binaryTree.right.right.left = new TreeNode(5);
        binaryTree.right.right.right = new TreeNode(1);

        System.out.println(maxDepth(binaryTree));
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
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
