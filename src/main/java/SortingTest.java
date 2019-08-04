import org.junit.Assert;
import org.junit.Test;

public class SortingTest {

    int[] A = {1, 3, 6, 4, 1, 2};

    @Test
    public void testBubbleSort() {
        int[] B = new BubbleSortSolution().sort(A);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        Assert.assertNotNull(B);
    }


    @Test
    public void testQuickSort() {
        int[] B = new QuickSortSolution().sort(A, 0, A.length-1);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        Assert.assertNotNull(B);
    }
}
