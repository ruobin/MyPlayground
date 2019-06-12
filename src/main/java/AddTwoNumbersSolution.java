public class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode resultNode = node;
        int tag = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tag;
            if (sum < 10) {
                tag = 0;
                node.next = new ListNode(sum);
            } else {
                tag = 1;
                node.next = new ListNode(sum % 10);
            }

            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }

        while(l1 != null) {
            int sum = l1.val + tag;
            if (sum < 10) {
                tag = 0;
                node.next = new ListNode(sum);
            } else {
                tag = 1;
                node.next = new ListNode(sum % 10);
            }
            l1 = l1.next;
            node = node.next;
        }
        while(l2 != null) {
            int sum = l2.val + tag;
            if (sum < 10) {
                tag = 0;
                node.next = new ListNode(sum);
            } else {
                tag = 1;
                node.next = new ListNode(sum % 10);
            }
            l2 = l2.next;
            node = node.next;
        }
        if (tag == 1) {
            node.next = new ListNode(1);
        }

        return resultNode.next;
    }
}
