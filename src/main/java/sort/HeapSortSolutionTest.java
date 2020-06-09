package sort;

public class HeapSortSolutionTest {

    public static void main(String[] args) {
        int[] input = {3,5,1,7,9,6,2};
        heapsort(input);
    }

    private static void heapsort(int[] input) {
        int size = input.length;
        //heapify sub-trees first
        for (int i=size/2-1; i>=0; i--) {
            heapify(input, size, i);
        }

        //swap the largest to the end and heapify the rest
        for (int i=0; i<=size-1; i++) {
            int swap = input[0];
            input[0] = input[size-i-1];
            input[size-1] = swap;
            System.out.println("sorted elements: " + swap);
            heapify(input, size-i-1, 0);
        }

    }

    private static void heapify(int[] array, int size, int root) {
        if (size <= 0) return;
        int left = root*2+1;
        int right = root*2+2;

        int largest = root;
        if(left<size && array[left]>array[largest]) {
            largest = left;
        }

        if(right<size && array[right]>array[largest]) {
            largest = right;
        }

        if(largest != root) {
            int swap = array[largest];
            array[largest] = array[root];
            array[root] = swap;

            heapify(array, size, largest);
        }
    }
}
