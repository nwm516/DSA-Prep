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
Three Pointers without Extra Space (Solution 1)

nums1 has empty space at the end. If we back fill, overwriting never becomes
a problem. By compraing the largest remaining elements from both arrays
and placing the larger one at the current end position,
merging in place without extra space becomes possible.


*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialized to last index of nums1
        int last = m + n - 1;

        // Merge in reverse order
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m--;
            } else {
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }

        // Leftovers from nums2 filled into nums1
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }
}