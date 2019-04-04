
////Solution1
//public class Solution {
//    public ListNode FindKthToTail(ListNode head,int k) {
//        if(head == null)
//            return null;
//        ArrayList<ListNode> temp = new ArrayList();
//        ListNode curr = head;
//        while(curr != null){
//            temp.add(curr);
//            curr = curr.next;
//        }
//        if(k > temp.size() || k <= 0)
//            return null;
//        return temp.get(temp.size()-k);
//    }
//}


//Solution2
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        int count = 0;
        if(head == null || k <= 0)
            return null;
        ListNode front = head, back = head;
        while(front.next != null && count < k-1){
            front = front.next;
            ++count;
        }
        if(count < k-1)
            return null;
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        return back;
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