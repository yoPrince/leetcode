public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        one.next = new ListNode(1);

        new Solution().deleteDuplicates(head);
        ListNode tmp = head;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while(tmp != null){
            if(tmp.next != null && tmp.next.val == tmp.val) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
    }
}