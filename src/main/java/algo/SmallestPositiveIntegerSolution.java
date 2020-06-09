package algo;

public class SmallestPositiveIntegerSolution {

    public int solution(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= A.length) {
                B[A[i] - 1] = 1;
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 0) {
                System.out.println(i + 1);
                return i + 1;
            }
        }
        System.out.println(B.length + 1);
        return B.length + 1;
    }
}
