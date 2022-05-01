package algo;

public class MinimumIndexWithValueGreaterThanTargetSolution {

    public int solution(int[] array, int target) {
        return findIndex(array, target, 0, array.length - 1);
    }

    int findIndex(int[] array, int target, int start, int end) {
        if (array[0] > target) return 0;
        if (array[array.length - 1] < target) return -1;
        int mid = (start + end )/2;
        System.out.println("initial mid is " + mid);
        while(start < end) {
            if (array[mid] <= target) {
                start = mid+1;
                if (array[start] > target) {
                    return start;
                }
                System.out.println("update start to " + start);
            } else {
                if (mid >= end) {
                    return mid;
                }
                end = mid;
                System.out.println("update end to " + end);
            }
            mid = (start + end )/2;
            System.out.println("update mid to " + mid);
        }
        if (array[mid] <= target) return -1;

        return mid;


    }

}
