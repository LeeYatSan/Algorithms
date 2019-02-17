import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        list1.getLastNode().addNext(2);
        list1.getLastNode().addNext(4);
        list2.getLastNode().addNext(3);
        list2.getLastNode().addNext(4);

        ListNode temp1 = list1, temp2 = list2;
        while(temp1 != null){
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }
        System.out.println("\n");
        while(temp2 != null){
            System.out.print(temp2.val + " ");
            temp2 = temp2.next;
        }
        System.out.println("\n");

        Solution s = new Solution();
        ListNode curr = s.mergeTwoLists(list1, null);
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            temp.add(curr.val);
            curr = curr.next;
        }
        System.out.print(temp.get(0));
        for(int i = 1; i < temp.size(); ++i)
            System.out.print("->" + temp.get(i));
    }
}
