/*
m = number of valid elements in nums1
n = number of valid elements in nums2
    - valid being non-zero elements

nums1.length = (m + n)
    - first m elements contain values to be merged, with last n elements set to 0 placeholders

there is space within nums1 to account for the valid elements in nums2, with nums2's values replacing the zeroes in nums1

approach:
if m = nums1.length, break and print array.

with a for loop, scan elements of nums1. if index of loop = 0, additional if to see if i  replace with first element of nums2. increment nums2's index up one.



*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
                
        int j = 0;

        for (int i = 0; i < nums1.length; i++){

            if (m == nums1.length){
                System.out.println(nums1);
            }

            if (nums1[i] == 0){
                if (j < n){
                    nums1[i] = nums2[j];
                    j++;
                }
            }
        }

        Arrays.sort(nums1);


        System.out.println(nums1);
    }
}