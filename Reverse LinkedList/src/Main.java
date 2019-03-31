import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ListNode head = new ListNode(67);
        ListNode curr = head;
        curr.add(0);
        curr = curr.next;
        curr.add(24);
        curr = curr.next;
        curr.add(58);

        ArrayList<Integer> result = (new Solution()).printListFromTailToHead(head);
        for(int i : result)
            System.out.println(i);
    }
}
