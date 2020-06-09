package sort;

public class QuickSortSolutionPractice {

    public static void main(String[] args) {
        int[] input = {3,2,5,6,9,1,0,4,7,8};
        int size = input.length;

        quickSort(input, 0, size-1);

        for (int i: input) {
            System.out.println("sorted elements: " + i);
        }
    }

    private static void quickSort(int[] input, int start, int end) {
        int size = end-start+1;
        if (size <= 1) {
            return;
        } else if (size == 2) {
            if (input[start]>input[end]) {
                int swap = input[end];
                input[end] = input[start];
                input[start] = swap;
            }

            return;
        }

        //swap according to the pivot

        int i=start;
        int j=end-1;

        while (i<=j) {
            if (input[i]<=input[end]) {
                i++;
                continue;
            }
            if (input[j]>input[end]) {
                j--;
                continue;
            }

//            if (input[i]>input[end] && input[j]<input[end]) {
                int swap = input[i];
                input[i] = input[j];
                input[j] = swap;
                i++;
                j--;
//            }
        }

        int swap = input[i];
        input[i] = input[end];
        input[end] = swap;

        //quickSort left sub array
        quickSort(input, start, i-1);
        quickSort(input, i+1, end);

    }

}
