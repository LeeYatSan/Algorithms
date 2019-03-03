class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;//cut the linked list into two sub linked list
        return merge(mergeSort(head), mergeSort(midNext));
    }

    private ListNode getMiddle(ListNode head){//to find the middle node
        if(head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode head = left.val < right.val ? left : right;
        ListNode currLeft = head == left ? left.next : left;
        ListNode currRight = head == right ? right.next : right;
        ListNode curr = head;
        while(currLeft != null && currRight != null){
            curr.next = currLeft.val < currRight.val ? currLeft : currRight;
            curr = curr.next;
            if(curr == currLeft)
                currLeft = currLeft.next;
            else
                currRight = currRight.next;
        }
        curr.next = currLeft == null ? currRight : currLeft;
        return head;
    }
}