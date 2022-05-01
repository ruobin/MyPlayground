package sort;

public class HeapSortSolutionTest {

    public static void main(String[] argument) {
        int[] arr = {1, 3, 36, 2, 19, 25, 100, 17, 7};

        buildHeapFromArray(arr, arr.length);

        heapSortWithHeapifiedArray(arr);
    }

    static void heapSortWithHeapifiedArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int rootValue = arr[0];
            arr[0] = arr[i];
            arr[i] = rootValue;
            sift(arr, i, 0);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void buildHeapFromArray(int[] arr, int size) {
        System.out.println("building heap from array");
        for (int i = size/2-1; i >= 0; i--) {
            sift(arr, size, i);
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n===================");
    }

    static void sift(int[] arr, int size, int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;
        if (left < size && arr[left] > arr[parent]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != parent) {
            int swap = arr[parent];
            arr[parent] = arr[largest];
            arr[largest] = swap;
            sift(arr, size, largest);
        }
    }
}
