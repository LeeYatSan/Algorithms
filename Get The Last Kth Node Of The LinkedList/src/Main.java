public class Main {
    public static void main(String[] args){
        int target = 2;
        ListNode head = new ListNode(67);
        ListNode curr = head;
        curr.add(0);
        curr = curr.next;
        curr.add(24);
        curr = curr.next;
        curr.add(58);

        curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println((new Solution()).FindKthToTail(head, target).val);
    }
}