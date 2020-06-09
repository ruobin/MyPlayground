package sort;

import java.sql.Array;

public class HeapSortSolution {

    public static void main(String[] args) {

        int[] input = {3,2,5,6,9,12};
        int size = input.length;

        for (int i=size/2 -1; i>=0; i--) {
            heapify(input, size, i);
        }

        for (int i = 0; i<size-1; i++) {
            int swap = input[0];
            input[0] = input[size-i-1];
            input[size-i-1] = swap;
            heapify(input, size-i-1, 0);
        }

        System.out.println(input);

    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int size, int node) {
        int largest = node;
        int leftChild = 2*node + 1;
        int rightChild = 2*node + 2;

        if (leftChild < size && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != node) {
            int swap = arr[node];
            arr[node] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, size, largest);
        }

    }

}
