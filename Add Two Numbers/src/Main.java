public class Main {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l2.next = new ListNode(6);
        l1.next.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution s = new Solution();
        ListNode res = s.addTwoNumbers(l1, l2);
        ListNode curr = res;
        while (curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}
