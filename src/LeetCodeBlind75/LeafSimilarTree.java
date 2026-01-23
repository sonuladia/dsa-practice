package LeetCodeBlind75;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        gatherLeaves(root1, leaves1);
        gatherLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public void gatherLeaves(TreeNode node, List leaves){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            leaves.add(node.val);
            return;
        }
        gatherLeaves(node.left, leaves);
        gatherLeaves(node.right, leaves);
    }

    public static void main(String[] args) {
        // Tree 1 construction
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        // Tree 2 construction
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        LeafSimilarTree solution = new LeafSimilarTree();
        boolean result = solution.leafSimilar(root1, root2);

        System.out.println("Are the trees leaf-similar? " + result);
    }
}
