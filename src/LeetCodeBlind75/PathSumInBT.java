package LeetCodeBlind75;

import java.util.HashMap;
import java.util.Map;

public class PathSumInBT {

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

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    public int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount){
        if(node == null)
            return 0;
        currentSum += node.val;
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, targetSum, prefixSumCount);
        count += dfs(node.right, currentSum, targetSum, prefixSumCount);

        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return count;
    }

    public static void main(String[] args) {

        PathSumInBT.TreeNode root = new PathSumInBT.TreeNode(10);
        root.left = new PathSumInBT.TreeNode(5);
        root.right = new PathSumInBT.TreeNode(-3);

        root.left.left = new PathSumInBT.TreeNode(3);
        root.left.right = new PathSumInBT.TreeNode(2);

        root.right.right = new PathSumInBT.TreeNode(11);

        root.left.left.left = new PathSumInBT.TreeNode(3);
        root.left.left.right = new PathSumInBT.TreeNode(-2);

        root.left.right.right = new PathSumInBT.TreeNode(1);

        PathSumInBT solution = new PathSumInBT();
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);

        System.out.println("Number of paths with sum " + targetSum + " = " + result);
    }
}
