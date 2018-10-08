public class RemoveNthNodeFromEndofList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = new Solution().removeNthFromEnd(head,3);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int cnt = 0;
        while(cnt < n){
            pre = pre.next;
            cnt++;
        }
        ListNode end = head;
        if(pre == null) return head.next;
        while(pre.next != null){
            pre = pre.next;
            end = end.next;
        }
        end.next = end.next.next;
        return head;
    }
}