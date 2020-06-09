package algo;

/**
 * Created by Ruobin Wang on 2019-08-02.
 */
public class RemoveElementSolution {

    public int removeElement(int[] nums, int val) {

        int i = 0;
        int j = nums.length - 1;

        while (i<=j) {
            if(nums[i]==val) {
                if(nums[j]==val) {
                    j--;
                } else {
                    //swap
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            } else i++;
        }

        return i;
    }
}
