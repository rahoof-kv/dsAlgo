package study.algo.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfNodesEachLevel {

    public static void main(String[] args) {

        /*
        *          3
        *         /  \
        *        9   20
        *           /  \
        *          15   7
        * */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> averages = getAverages(root);

        for (Double avg :averages) {
            System.out.println(avg);
        }

    }

    private static List<Double> getAverages(TreeNode root) {

        List<Double> averages = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){

            int count = queue.size();
            int sum = 0;

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();

                sum += node.value;

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            averages.add(sum/(double)count);

        }
        return averages;
    }


    static class TreeNode{
        TreeNode left, right;
        Integer value;

        public TreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

}


