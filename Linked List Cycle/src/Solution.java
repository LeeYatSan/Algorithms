////Solution1
//import java.util.HashSet;
//import java.util.Set;
//
//public class Solution {
//    public boolean hasCycle(ListNode head) {
//        if(head == null || head.next == null)
//            return false;
//        Set<ListNode>nodeSet = new HashSet<>();
//        ListNode curr = head;
//        while(curr != null){
//            if(nodeSet.contains(curr))
//                return true;
//            else {
//                nodeSet.add(curr);
//                curr = curr.next;
//            }
//        }
//        return false;
//    }
//}

//Solution2
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        if(head == null || head.next == null)
            return false;
        else {
            while(fast != null && slow != null){
                fast = fast.next;
                slow = slow.next;
                if(fast != null)
                    fast = fast.next;
                else return false;
                if(fast == slow)
                    return true;
            }
            return false;
        }
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
