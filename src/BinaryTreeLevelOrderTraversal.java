import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<List<Integer>> ret = new Solution().levelOrder(root);
        for( List i : ret) System.out.println(i);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        List<List<Integer>> ret = new ArrayList<>();
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            for( int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if(tmp != null){
                    list.add(tmp.val);
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
            if(list.size() > 0) ret.add(list);
        }
        return ret;
    }
}