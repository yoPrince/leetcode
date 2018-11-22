public class LinkedListCycle {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        head.next = h2;
        h2.next = head;
        System.out.println(new Solution().hasCycle(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, low = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if(fast == low) return true;
        }
        return false;
    }
}