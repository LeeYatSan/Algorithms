class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, post;
        ListNode curr = head;
        while(curr != null){
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        return pre;
    }
}