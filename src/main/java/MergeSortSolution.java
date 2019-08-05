/**
 * Created by Ruobin Wang on 2019-08-04.
 */
public class MergeSortSolution {

    public int[] sort(int[] sourceArray) {
        int[] targetArray = new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            targetArray[i] = sourceArray[i];
        }

        sort(sourceArray, 0, sourceArray.length - 1, targetArray);
        return targetArray;
    }

    public void sort(int[] sourceArray, int start, int end, int[] targetArray) {

        if (end == start) return;
        int middle = (start + end) / 2;
        sort(targetArray, start, middle, sourceArray);
        sort(targetArray, middle + 1, end, sourceArray);
        merge(sourceArray, start, middle, end, targetArray);
    }

    private int[] merge(int[] sourceArray, int start, int middle, int end, int[] targetArray) {
        int i = start;
        int j = middle + 1;

        int k = start;
        while (i <= middle || j <= end) {
            if (i > middle) {
                targetArray[k] = sourceArray[j];
                k++;
                j++;
                continue;
            }
            if (j > end) {
                targetArray[k] = sourceArray[i];
                k++;
                i++;
                continue;
            }
            if (sourceArray[i] <= sourceArray[j]) {
                targetArray[k] = sourceArray[i];
                k++;
                i++;
            } else {
                targetArray[k] = sourceArray[j];
                k++;
                j++;
            }
        }

        return targetArray;
    }
}
