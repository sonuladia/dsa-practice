package LeetCodeBlind75;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }

    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1, maxSum = Integer.MIN_VALUE, res = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int levelSum = 0;
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                levelSum += node.val;
            }
            if(levelSum > maxSum){
                maxSum = levelSum;
                res = level;
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxLevelSumOfBT solution = new MaxLevelSumOfBT();

        // Constructing the tree manually:
        TreeNode root = new TreeNode(989);
        root.right = new TreeNode(10250);
        root.right.right = new TreeNode(-89388);
        root.right.right.left = new TreeNode(-32127);

        // Now call the function
        int result = solution.maxLevelSum(root);

        System.out.println("Maximum Level Sum is at Level: " + result);
    }
}
