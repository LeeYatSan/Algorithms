public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    void addNext(int x){
        next = new ListNode(x);
    }

    ListNode getLastNode(){
        ListNode curr = this;
        while(curr.next != null)
            curr = curr.next;
        return curr;
    }
}