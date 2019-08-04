/**
 * Created by Ruobin Wang on 2019-08-04.
 */
public class QuickSortSolution {

    private int partition(int[] B, int start, int end) {

        int i=start;
        int j=end-1;
        while (i<=j) {
            if(B[i]<=B[end]) {
                i++;
                continue;
            }
            if(B[j]>B[end]) {
                j--;
                continue;
            }

            int temp = B[j];
            B[j] = B[i];
            B[i] = temp;
            i++;
            j--;
        }

        int temp1 = B[i];
        B[i] = B[end];
        B[end] = temp1;
        return i;

    }

    public int[] sort(int[] A, int start, int end) {

        int pivot = partition(A, start, end);
        if(start < pivot-1) {
            sort(A, start, pivot - 1);
        }
        if(pivot+1 < end) {
            sort(A, pivot+1, end);
        }
        return A;
    }

}
