import java.util.Stack;

public class DFSSolutionPractice {

//                        5
//                      /  \
//                     2    6
//                    / \  /  \
//                  7   1  9   4
//                 /
//                3

    static int[] array = {5,2,6,7,1,9,4,3};

    public static void main(String[] args) {

        Node[] nodes = buildNodeArray(array);

        DFSTraverse(nodes[0]);

    }

    static void DFSTraverse(Node root) {
        if (root == null)
            return;
        if (root.left != null) {
            DFSTraverse(root.left);
        }

        System.out.println("DFS traversing node: " + root.value);

        if (root.right != null) {
            DFSTraverse(root.right);
        }

//        if (root.left == null && root.right == null) {

//        }

//        Stack<Node> nextToVisitSet = new Stack<Node>();
//        nextToVisitSet.push(binaryTree[0]);
//        Node nextNodeToVisit = nextToVisitSet.peek();
//        if (nextNodeToVisit != null) {
//            if (nextNodeToVisit.left != null) {
//                nextToVisitSet.push(nextNodeToVisit.left);
//            }
//            if (nextNodeToVisit.right != null) {
//                nextToVisitSet.push(nextNodeToVisit.right);
//            }
//        }
    }

    static class Node {
        Node left;
        Node right;
        int value;
    }

    static Node[] buildNodeArray(int[] array) {
        Node[] nodes = new Node[array.length];
        for (int i = 0; i < array.length; i++) {
            Node node = new Node();
            node.value = array[i];
            nodes[i] = node;
        }

        for (int i = 0; i < array.length; i++) {
            if(2*i+1<array.length) {
                nodes[i].left = nodes[2*i+1];
                System.out.println("node: "+array[i] + "'s left child is node: " + array[2*i+1]);
            }
            if(2*i+2<array.length) {
                nodes[i].right = nodes[2*i+2];
                System.out.println("node: "+array[i] + "'s right child is node: " + array[2*i+2]);
            }
        }

        return nodes;
    }
}
