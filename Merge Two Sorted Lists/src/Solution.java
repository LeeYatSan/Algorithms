class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //solution1:
        ListNode result = null, curr1, curr2, result_curr;
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null && l2 != null)
            return l2;
        else if(l1 != null && l2 == null)
            return l1;
        else {
            if(l1.val <= l2.val){
                result = l1;
                curr1 = l1.next;
                curr2 = l2;
            }
            else{
                result = l2;
                curr1 = l1;
                curr2 = l2.next;
            }
            result_curr = result;
            while(curr1 != null || curr2 != null){
                if(curr1 == null){
                    result_curr.next = curr2;
                    return result;
                }
                else if(curr2 == null){
                    result_curr.next = curr1;
                    return result;
                }
                else {
                    if(curr1.val <= curr2.val){
                        result_curr.next = curr1;
                        result_curr = result_curr.next;
                        curr1 = curr1.next;
                    }
                    else{
                        result_curr.next = curr2;
                        result_curr = result_curr.next;
                        curr2 = curr2.next;
                    }
                }
            }
            return result;
        }
    }
}