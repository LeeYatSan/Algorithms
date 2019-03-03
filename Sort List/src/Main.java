public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode head = new ListNode(4);
        ListNode curr = head;
        curr.next = new ListNode(2);
        curr = curr.next;
        curr.next = new ListNode(1);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = s.sortList(head);
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
