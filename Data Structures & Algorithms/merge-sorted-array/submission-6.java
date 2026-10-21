/*
there will be space within nums1 to account for the numbers in nums2 to be accounted for.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int j = 0;
        int span = nums2.length;

        for (int i = 0; i < nums1.length; i++){
            if (nums1[i] == 0){
                if (j < span)
                    nums1[i] = nums2[j];
                    j++;
            }
        }
        Arrays.sort(nums1);

        System.out.println(nums1);
    }
}