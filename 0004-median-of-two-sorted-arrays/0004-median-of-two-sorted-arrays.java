class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merge = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merge[k] = nums1[i];
                i++;
            } else {
                merge[k] = nums2[j];
                j++;
            }
            k++;
        }

       
        while (i < nums1.length) {
            merge[k] = nums1[i];
            i++;
            k++;
        }

        // Copy remaining elements of nums2
        while (j < nums2.length) {
            merge[k] = nums2[j];
            j++;
            k++;
        }

        int n = merge.length;

        // If total length is odd
        if (n % 2 == 1) {
            return merge[n / 2];
        }

        // If total length is even
        return (merge[n / 2 - 1] + merge[n / 2]) / 2.0;
    }
}