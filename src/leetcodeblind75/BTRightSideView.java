package leetcodeblind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(i == levelSize-1)
                    result.add(node.val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BTRightSideView.TreeNode node5 = new BTRightSideView.TreeNode(5);
        BTRightSideView.TreeNode node4 = new BTRightSideView.TreeNode(4);
        BTRightSideView.TreeNode node2 = new BTRightSideView.TreeNode(2, null, node5);
        BTRightSideView.TreeNode node3 = new BTRightSideView.TreeNode(3, null, node4);
        BTRightSideView.TreeNode root = new BTRightSideView.TreeNode(1, node2, node3);

        BTRightSideView solver = new BTRightSideView();
        List<Integer> result = solver.rightSideView(root);

        System.out.println("Right Side View: " + result);
    }
}
