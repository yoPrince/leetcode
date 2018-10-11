public class ReverseNodesinKGroup {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for(int i = 2; i <= 5; i++){
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        head = new Solution().reverseKGroup(head, 2);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        for(int i = 1; head != null; i++){
            if(i % k == 0){
                ListNode tmp1 = head.next, tmp2 = pre.next;
                reverse(pre, head);
                head = tmp1;
                pre = tmp2;
            } else head = head.next;
        }
        return fake.next;
    }

    void reverse(ListNode head, ListNode cur){
        ListNode tmp = head.next;
        while(tmp != cur){
            head.next = tmp.next;
            tmp.next = cur.next;
            cur.next = tmp;
            tmp = head.next;
        }
    }
}
