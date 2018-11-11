public class SameTree {
    public static void main(String[] args){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(new Solution().isSameTree(p, q));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val){
            if(isSameTree(p.left, q.left)) return isSameTree(p.right, q.right);
        }
        return false;
    }
}