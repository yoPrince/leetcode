public class MaximumDepthofBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        System.out.println(new Solution().maxDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}