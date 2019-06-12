import org.junit.Test;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {

    /**
     * problem 3
     *
     * @param nums1
     * @param nums2
     * @return
     */
    @Test
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int[] mergedNums = new int[nums1.length + nums2.length];
        ArrayList mergedNumsList = new ArrayList(nums1.length + nums2.length);
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedNumsList.add(nums1[i]);
                i++;
            } else {
                mergedNumsList.add(nums2[j]);
                j++;
            }
        }
        while (i<nums1.length) {
            mergedNumsList.add(nums1[i]);
            i++;
        }
        while (j<nums2.length) {
            mergedNumsList.add(nums2[j]);
            j++;
        }
        if(mergedNumsList.size()%2 == 1) {
            return Double.valueOf((Integer) mergedNumsList.get((mergedNumsList.size()-1)/2));
        } else {
            return  (Double.valueOf((Integer) mergedNumsList.get(mergedNumsList.size()/2 - 1)) + Double.valueOf((Integer) mergedNumsList.get(mergedNumsList.size()/2)))/2;
        }

    }
}
