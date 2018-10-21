public class MergekSortedLists {
    public static void main(String[] args){
        ListNode h1 = null;
        ListNode h2 = new ListNode(1);
        ListNode[] lists = {h1, h2};
        ListNode ret = new Solution().mergeKLists(lists);
        while(ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(lists == null || len == 0) return null;
        if(len == 1) return lists[0];
        return merge(lists, 0, len - 1);
    }

    ListNode merge(ListNode[] lists, int l, int r){
        if(l < r){
            int m = (l + r) >> 1;
            lists[l] = mergeTwoLists(merge(lists, l, m), merge(lists, m + 1, r));
        }
        return lists[l];
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode ret = new ListNode(-1);
        ListNode tmp = ret;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        while(l1 != null) {
            tmp.next = l1;
            tmp = tmp.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            tmp.next = l2;
            tmp = tmp.next;
            l2 = l2.next;
        }
        return ret.next;
    }
}