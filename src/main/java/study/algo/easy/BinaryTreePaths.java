package study.algo.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        dfs(root, "", paths);

        return paths;
    }

    private void dfs(TreeNode root,String path,  List<String> paths ) {

        path += root.val;

        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        if (root.left != null) {
            dfs(root.left, path + "->", paths);
        }

        if (root.right != null) {
            dfs(root.right, path + "->", paths);
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
