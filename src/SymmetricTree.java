import java.util.LinkedList;

public class SymmetricTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(new Solution().isSymmetric(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> left = new LinkedList<>();
        LinkedList<TreeNode> right = new LinkedList<>();
        left.offer(root.left);
        right.offer(root.right);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode l = left.poll(), r = right.poll();
            if(l == null && r == null) continue;
            if(l == null || r == null) return false;
            if(l.val == r.val){
                left.offer(l.left);
                left.offer(l.right);
                right.offer(r.right);
                right.offer(r.left);
            } else return false;
        }
        if(left.isEmpty() && right.isEmpty()) return true;
        return false;
    }
}