/*
Merge Sorted Array

You are given two integer arrays nums1 and nums2, both sorted in non-decreasing order, along with two integers m and n, where:

    m is the number of valid elements in nums1,

    n is the number of elements in nums2.

The array nums1 has a total length of (m+n), with the first m elements containing the values to be merged, and the last n elements set to 0 as placeholders.

Your task is to merge the two arrays such that the final merged array is also sorted in non-decreasing order and stored entirely within nums1.
You must modify nums1 in-place and do not return anything from the function.

Example 1:

Input: nums1 = [10,20,20,40,0,0], m = 4, nums2 = [1,2], n = 2

Output: [1,2,10,20,20,40]

Example 2:

Input: nums1 = [0,0], m = 0, nums2 = [1,2], n = 2

Output: [1,2]

Constraints:

    0 <= m, n <= 200
    1 <= (m + n) <= 200
    nums1.length == (m + n)
    nums2.length == n
    -1,000,000,000 <= nums1[i], nums2[i] <= 1,000,000,000

*/

/*
Three Pointers with Extra Space

Given that both arrays are already sorted, we can merge them in linear time using
the standard merge technique from merge sort.
Writing directly into nums1 from the front risks overwriting needed elements,
so to avoid this, we first copy the original elements of nums1 to a temporary array,
then merging from both sources into nums1.

Time: O(m + n)
Space: O(m)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        
        /*
        Three pointers:
        - i for the nums1 copy
        - j for nums2
        - idx for the write position in nums1
        */
        int idx = 0, i = 0, j = 0;

        while (idx < m + n) {
            if (j >= n || (i < m && nums1Copy[i] <= nums2[j])) {
                nums1[idx++] = nums1Copy[i++];
            } else {
                nums1[idx++] = nums2[j++];
            }
        }
    }
}