package algo;

import basics.ListNode;

/**
 * Created by Ruobin Wang on 2019-07-02.
 */
public class SwapNodesInPairsSolution {

    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        head = secondNode;

        firstNode.next = swapPairs(firstNode.next);

        return head;
    }

}
