class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null)
            return head;
        ListNode tail = head, res, curr = head;
        int count = 1, diff, currCount = 1;
        while(tail.next != null){
            tail = tail.next;
            ++count;
        }
        tail.next = head;
        diff = count-k%count;
        while(currCount < diff){
            curr = curr.next;
            ++currCount;
        }
        res = curr.next;
        curr.next = null;
        return res;
    }
}