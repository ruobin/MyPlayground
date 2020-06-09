package algo;

public class NextPermutationSolution {

    public void nextPermutation(int[] nums) {
        //13542
        //find a[i-1] < a[i]
        int a = -1;
        for (int i = nums.length-1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]) {
                a = i-1;
                break;
            }
        }
        if (a >=0) {
            for (int j = nums.length - 1; j > a; j--) {
                if (nums[j] > nums[a]) {
                    int swap = nums[a];
                    nums[a] = nums[j];
                    nums[j] = swap;
                    break;
                }
            }
        }
        //14532, a=1
        //target 14235
        //loop between a+1 and length-1
        for (int m = a+1; m <= (nums.length + a)/2; m++) {
            //swap nums[m] and nums[nums.length-m+a]
            int swap = nums[m];
            nums[m] = nums[nums.length-m+a];
            nums[nums.length-m+a] = swap;
        }
    }
}
