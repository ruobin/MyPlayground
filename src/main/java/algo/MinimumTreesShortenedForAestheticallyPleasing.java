package algo;

public class MinimumTreesShortenedForAestheticallyPleasing {
    private final static int INCREASE = 1;
    private final static int DECREASE = -1;
    private final static int EQUAL = 0;

    public int solution(int[] A) {
        int leftPointer = 0;
        int rightPointer = 1;
        int lastFlag = EQUAL;
        int shortenSum = 0;

        //using two pointers to loop through the array
        while (rightPointer < A.length) {
            if (A[leftPointer] < A[rightPointer]) {
                if (lastFlag == DECREASE || lastFlag == EQUAL) {
                    lastFlag = INCREASE;
                } else {
                    A[rightPointer] = 0;
                    shortenSum++;
                    lastFlag = DECREASE;
                }
            } else if (A[leftPointer] > A[rightPointer]) {
                if (lastFlag == INCREASE || lastFlag ==EQUAL) {
                    lastFlag = DECREASE;
                } else {
                    A[leftPointer] = 0;
                    shortenSum++;
                    lastFlag = INCREASE;
                }
            } else {
                if (lastFlag == EQUAL || lastFlag == INCREASE) {
                    A[rightPointer] = 0;
                } else {
                    A[leftPointer] = 0;
                }
                shortenSum++;
            }

            leftPointer++;
            rightPointer++;
        }

        return shortenSum;
    }
}
