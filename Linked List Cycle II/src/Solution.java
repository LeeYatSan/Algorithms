import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

////Solution1 [Unaccepted] Exceeding Time Limit
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head, slow = head;
//        while(fast.next != null && fast.next.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(slow == fast){
//                return getStart(head, slow);
//            }
//        }
//        return null;
//    }
//    private ListNode getStart(ListNode head, ListNode circle){
//        if(head == circle || head == null || head.next == null)
//            return head;
//        ListNode curr = head, currCircle = circle;
//        while(curr != null){
//            while(currCircle.next != circle){
//                if(currCircle == curr)
//                    return curr;
//                currCircle = currCircle.next;
//            }
//            curr = curr.next;
//        }
//        return null;
//    }
//}

////Solution2 [Unaccepted] Exceeding Time Limit
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        if(head == null)
//            return head;
//        ListNode fast = head, slow = head;
//        while(fast.next != null && fast.next.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(slow == fast){
//                return getStart(head, slow);
//            }
//        }
//        return null;
//    }
//
//    private ListNode getStart(ListNode head, ListNode circle){
//        if(head == circle || head == null || head.next == null)
//            return head;
//        ListNode curr = head, currCircle = circle;
//        Set<ListNode> circleNodes = new HashSet<>();
//        while(currCircle.next != circle){
//            circleNodes.add(currCircle);
//            currCircle = currCircle.next;
//        }
//        while(true){
//            if(circleNodes.contains(curr))
//                return curr;
//            curr = curr.next;
//        }
//    }
//}

//Solution3
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                ListNode curr = head;
                while(curr != slow){
                    curr = curr.next;
                    slow = slow.next;
                }
                return curr;
            }
        }
        return null;
    }
}