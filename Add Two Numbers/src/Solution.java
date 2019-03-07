import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = transToNumber(l1);
        int num2 = transToNumber(l2);
        int res = num1+num2;
        ListNode resList = new ListNode(0);
        ListNode curr = resList;
        if(res == 0)
            return resList;
        while(res != 0){
            curr.next = new ListNode(res%10);
            curr = curr.next;
            res /= 10;
        }
        return resList.next;
    }
    private int transToNumber(ListNode list){
        Stack<Integer> tmp = new Stack();
        int res = 0;
        ListNode curr = list;
        while(curr != null){
            tmp.push(curr.val);
            curr = curr.next;
        }
        while(!tmp.isEmpty())
            res = res*10+tmp.pop();
        return res;
    }
}