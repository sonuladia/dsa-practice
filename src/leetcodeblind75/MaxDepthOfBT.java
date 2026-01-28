package leetcodeblind75;

public class MaxDepthOfBT {

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

 public int maxDepth(TreeNode root) {
  if(root == null)
   return 0;
  return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

 }

 public static void main(String[] args) {
  MaxDepthOfBT solution = new MaxDepthOfBT();

  TreeNode root = new TreeNode(1);
  root.left = new TreeNode(2);
  root.left.left = new TreeNode(4);
  root.right = new TreeNode(3);

  int depth = solution.maxDepth(root);
  System.out.println("Max Depth = " + depth);  // Output should be 3
 }

}
