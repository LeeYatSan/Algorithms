////solution1
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null)
//            return null;
//        else{
//            int lenA = countLen(headA);
//            int lenB = countLen(headB);
//            int diff = 0;
//            ListNode currA = headA;
//            ListNode currB = headB;
//            if(lenA >= lenB){
//                for(int i = 0; i < lenA - lenB; ++i)
//                    currA = currA.next;
//            }
//            else{
//                for(int i = 0; i < lenB - lenA; ++i)
//                    currB = currB.next;
//            }
//            while(currA != currB && currA != null && currB != null){
//                currA = currA.next;
//                currB = currB.next;
//            }
//            return currA;
//        }
//    }
//    private int countLen(ListNode node){
//        ListNode curr = node;
//        int count = 0;
//        while(curr.next != null){
//            ++count;
//            curr = curr.next;
//        }
//        return count;
//    }
//}

////solution2
//import java.util.HashSet;
//        import java.util.Set;
//
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null)
//            return null;
//        else{
//            Set<ListNode>nodeSet = new HashSet();
//            ListNode curr = headA;
//            while(curr != null){
//                nodeSet.add(curr);
//                curr = curr.next;
//            }
//            curr = headB;
//            while(curr != null){
//                if(nodeSet.contains(curr))
//                    return curr;
//                curr = curr.next;
//            }
//            return null;
//        }
//    }
//}

//solution3
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        else{
            ListNode currA = headA, currB = headB;
            while(currA != currB){
                currA = currA == null? headB : currA.next;
                currB = currB == null? headA : currB.next;
            }
            return currA;
        }
    }
}