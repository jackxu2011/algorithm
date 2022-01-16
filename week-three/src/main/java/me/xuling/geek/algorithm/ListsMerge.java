package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/1/16
 **/
public class ListsMerge {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return mergeKLists(0, lists.length -1, lists);
    }

    private ListNode mergeKLists(int start, int end, ListNode[] lists) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end-start)/2;
        ListNode left = mergeKLists(start, mid, lists);
        ListNode right = mergeKLists(mid+1, end, lists);
        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(left != null && right != null ) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }
        return result.next;
    }
}
