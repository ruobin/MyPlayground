public class LongestBiValuedSliceSolution {

    public int solution(int[] A) {

        int start1 = 0;
        int start2 = 0;
        int end = 0;

        int firstValue = A[0];
        int secondValue = A[0];

        int longestLength = 1;

        while (end < A.length - 1) {
            end++;
            if (A[end] == firstValue) {
                start2 = end;
                continue;
            }
            if (A[end] == secondValue) {
                continue;
            }

            longestLength = Math.max(longestLength, end - start1);

            firstValue = secondValue;
            secondValue = A[end];
            start1 = start2;
            start2 = end;
        }
        if (longestLength <= (end - start1)) {
            longestLength = end - start1 + 1;
        }
        return longestLength;
    }
}
