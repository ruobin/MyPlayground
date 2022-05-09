package sort;

/**
 * created by Ruobin Wang on 2022-05-02
 */
public class QuickSortPractice {

    public static void main(String[] arg) {
        int[] arr = {1, 3, 36, 2, 19, 25, 100, 17, 7};

        placeThePivot(arr, 0, arr.length-1);
    }

    // place the pivot where it should be
    static void placeThePivot(int[] arr, int low, int hi) {
        System.out.println("low is " + low + " and hi is " + hi);
        if (low >= hi) return;
        int pivot = arr[hi];
        System.out.print("\npivot is " + pivot + "\n");
        int i = low;
        int j = hi-1;
        while(i<j) {
            while (i<j && arr[i] < pivot) {
                i++;
            }

            while (j>i && arr[j] > pivot) {
                j--;
            }

            // swap between value i and j, i.e. between bigger than pivot and smaller than pivot
            if (i < j) {
                System.out.println("swap between " + i + " and " + j);
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }
        }

        System.out.println("========= print intermediate results =========");
        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr[m] + " ");
        }

        System.out.println("\nfinal i is " + i + " and j is " + j);
        int tmp = arr[hi];
        arr[hi] = arr[j];
        arr[j] = tmp;
        System.out.println("========= print final results =========");
        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.println("\n==================");

        placeThePivot(arr, low, j-1);
        placeThePivot(arr, j+1, hi);
    }

}
