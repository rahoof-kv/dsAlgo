package study.algo.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

        List<List<Integer>> nodes = pathSum(binaryTree, 22);

        System.out.println(nodes.toString());
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> paths = new ArrayList<>();
        findPathSum(paths, new ArrayList<>(), root, sum);
        return paths;
    }

    private static void findPathSum(List<List<Integer>> paths, List<Integer> currentPath, TreeNode root, int sum) {

        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            paths.add(currentPath);
            return;
        }

        findPathSum(paths, new ArrayList<>(currentPath), root.left, sum - root.val);
        findPathSum(paths, new ArrayList<>(currentPath), root.right, sum - root.val);


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
