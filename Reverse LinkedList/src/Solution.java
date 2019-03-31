import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList result = new ArrayList<Integer>();
        ListNode curr = listNode;
        if(curr == null)
            return result;
        ListNode pre = null;
        ListNode next = curr.next;
        while(next != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr = pre;
        while(curr != null){
            result.add(curr.val);
            curr = curr.next;
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    void add(int val){
        next = new ListNode(val);
    }
}