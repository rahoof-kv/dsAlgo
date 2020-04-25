package study.algo.medium;

public class ValidateBST {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(14);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isValidBSTHelper(root, null, null );
    }

    private static boolean isValidBSTHelper(TreeNode root, Integer max, Integer min) {

        if (root == null) {
            return true;
        } else if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        } else {
            return isValidBSTHelper(root.left, root.val, min) && isValidBSTHelper(root.right, max, root.val);
        }

    }
}
