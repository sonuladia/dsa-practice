package leetcodeblind75;

public class GoodNodeInBT {
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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int maxSoFar){
        if(node == null)
            return 0;
        int goodNodeCount = 0;
        if(node.val >= maxSoFar)
            goodNodeCount++;
        maxSoFar = Math.max(maxSoFar, node.val);
        goodNodeCount += dfs(node.left, maxSoFar);
        goodNodeCount += dfs(node.right, maxSoFar);
        return goodNodeCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(1), new TreeNode(5));

        GoodNodeInBT solver = new GoodNodeInBT();
        int result = solver.goodNodes(root);

        System.out.println("Number of good nodes: " + result);
    }
}
