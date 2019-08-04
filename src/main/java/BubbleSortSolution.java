/**
 * Created by Ruobin Wang on 2019-08-04.
 */
public class BubbleSortSolution {

    public int[] sort(int[] A) {

        for (int j = A.length; j > 0 ; j--) {
            for (int i = 0; i < j; i++) {
                if(i+1<j && A[i]>A[i+1]) {
                    int temp = A[i+1];
                    A[i+1] = A[i];
                    A[i] = temp;
                }
            }
        }

        return A;
    }
}
