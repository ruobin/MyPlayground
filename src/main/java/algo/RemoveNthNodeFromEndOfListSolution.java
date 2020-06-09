package algo;

import basics.ListNode;

public class RemoveNthNodeFromEndOfListSolution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode firstPointer = dummyNode;
        ListNode secondPointer = dummyNode;

        for (int i = 0; i < n + 1; i++) {
            secondPointer = secondPointer.next;
        }
        while (secondPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        firstPointer.next = firstPointer.next.next;
        return dummyNode.next;
    }

}
