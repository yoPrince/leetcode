public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new Solution().buildTree(preorder, inorder);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return build(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pre, int left, int right){
        if(right < left) return null;
        TreeNode root = new TreeNode(preorder[pre]);
        int idx = 0;
        for( idx = left; inorder[idx] != preorder[pre]; idx++);
        root.left = build(preorder, inorder, pre + 1, left, idx - 1);
        root.right = build(preorder, inorder, pre + 1 + idx - left, idx + 1, right);
        return root;
    }
}