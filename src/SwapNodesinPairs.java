import java.util.List;

public class SwapNodesinPairs {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);

        head.next = h2;
        h2.next = h3;
        h3.next = h4;

        head = new Solution().swapPairs(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode cur = fakeNode, tmp;
        while(cur.next != null && cur.next.next != null){
            tmp = cur.next.next;
            cur.next.next = tmp.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        return fakeNode.next;
    }
}