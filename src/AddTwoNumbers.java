public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(4);

        ListNode ans = new Solution().addTwoNumbers(l1, l2);
        while(ans != null){
            System.out.print(ans.val);
            ans = ans.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode a = l1, b = l2, tmp = ans;
        int carry = 0;
        while(a != null || b != null || carry > 0){
            if(a != null){
                carry += a.val;
                a = a.next;
            }
            if(b != null){
                carry += b.val;
                b = b.next;
            }
            tmp.next = new ListNode(carry % 10);
            tmp = tmp.next;
            carry /= 10;
        }
        return ans.next;
    }
}