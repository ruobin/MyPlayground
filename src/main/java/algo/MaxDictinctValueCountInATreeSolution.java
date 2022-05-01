package algo;

import java.util.HashSet;
import java.util.Set;

public class MaxDictinctValueCountInATreeSolution {

    static class Node {
        public Node(int value) {
            this.value = value;
        }
        int value;
        Node left;
        Node right;
    }

    public static Node constructTree() {
        Node head = new Node(9);
        Node l1 = new Node(5);
        Node l2 = new Node(0);
        Node l3 = new Node(4);
        Node l4 = new Node(8);
        Node l5 = new Node(5);
        Node r1 = new Node(2);
        Node r2 = new Node(1);
        Node r3 = new Node(4);
        head.left = l1;
        head.right = r1;
        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        l3.right = l5;
        r1.right = r2;
        r2.left = r3;
        return head;
    }

    int DFS(Node root, Set mSet) {

        if (root == null || mSet.contains(root.value)) {
            return mSet.size();
        }

        //Add the root to the set
        mSet.add(root.value);
        int l = DFS(root.left, mSet);
        int r = DFS(root.right, mSet);
        //Backtrack and remove the element from the set
        mSet.remove(root.value);

        //return the max path
        return Math.max(l, r);

//        set.add(root.value);
//        if(root.left == null && root.right == null) {
//            return set.size();
//        }
//        int l = 0;
//        if (root.left != null) {
//            l = DFS(root.left, set);
//            set.remove(root.left.value);
//        }
//        int r = 0;
//        if (root.right != null) {
//            r = DFS(root.right, set);
//            set.remove(root.right.value);
//        }
//        return Math.max(l, r);
    }

    public int solution() {
        Set set = new HashSet<>();
        return DFS(constructTree(), set);
    }
}
