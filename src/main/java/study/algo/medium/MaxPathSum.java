package study.algo.medium;

public class MaxPathSum {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(-3);

        /*binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);*/

        System.out.println(maxPathSum(binaryTree));
    }

    public static int maxPathSum(BinaryTree tree) {

        int[] maxSumArray = findMaxSum(tree);
        return maxSumArray[1];
    }

    private static int[] findMaxSum(BinaryTree tree) {
        if (tree == null) {
            return new int[]{-323232,-323232};
        }

        int[] leftMaxSumArray = findMaxSum(tree.left);
        int leftSumAsBranch = leftMaxSumArray[0];
        int leftMaxPathSum = leftMaxSumArray[1];

        int[] rightMaxSumArray = findMaxSum(tree.right);
        int rightSumAsBranch = rightMaxSumArray[0];
        int rightMaxPathSum = rightMaxSumArray[1];

        int maxChildSumAsBranch = Math.max(leftSumAsBranch,rightSumAsBranch);
        int maxSumAsBranch = Math.max(maxChildSumAsBranch+tree.value, tree.value);
        int maxSumWithRootNode = Math.max(maxSumAsBranch,  leftSumAsBranch + rightSumAsBranch + tree.value);
        int runningMaxPathSum = Math.max(maxSumWithRootNode, Math.max(leftMaxPathSum,rightMaxPathSum));

        return new int[]{maxSumAsBranch,runningMaxPathSum };
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
