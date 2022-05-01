package sort;

public class HeapSortSolution {

    public static void main(String[] args) {

        int[] input = {1, 3, 36, 2, 19, 25, 100, 17, 7};
        int size = input.length;
        buildHeapFromArray(input, size);

        for (int i = 0; i<size-1; i++) {
            int swap = input[0];
            input[0] = input[size-i-1];
            input[size-i-1] = swap;
            sift(input, size-i-1, 0);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(input[i] + ",");
        }
    }

    static void buildHeapFromArray(int[] input, int size) {
        System.out.println("heapify: building a heap from an array...");
        // build a max/min heap, and get the max/min value which is the root node
        for (int i = size/2 - 1; i >= 0; i--) {
            sift(input, size, i);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(input[i] + ",");
        }

        System.out.println("\n----------------");
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void sift(int arr[], int size, int node) {
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

            // Recursively sift the affected sub-tree
            sift(arr, size, largest);
        }
    }
}
