package basics;

import java.util.LinkedList;

public class BFSSolutionPractice {

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

        BFSTraverse(nodes);

    }

    static void BFSTraverse(Node[] binaryTree) {
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        nextToVisit.add(binaryTree[0]);

        while (!nextToVisit.isEmpty()) {
            Node element = nextToVisit.poll();
            System.out.println("printing elements: " + element.value);
            if (element.left != null)
                nextToVisit.add(element.left);
            if (element.right != null)
                nextToVisit.add(element.right);
        }
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
