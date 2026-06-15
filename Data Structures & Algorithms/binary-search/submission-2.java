/*
Binary Search

You are given an array of distinct integers nums, sorted in ascending order, and an integer target.

Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.

Your solution must run in O(logn)O(logn) time.

Example 1:

Input: nums = [-1,0,2,4,6,8], target = 4

Output: 3

Example 2:

Input: nums = [-1,0,2,4,6,8], target = 3

Output: -1

Constraints:

    1 <= nums.length <= 10000.
    -10000 < nums[i], target < 10000
    All the integers in nums are unique.

*/

/*
Lower Bound Solution

This solution finds the first index where a value is greater than or equal to the target.
If the target exists in the array, this lower-bound index will point exactly to its first occurence.

Instead od directly searching for the equality, we search for the leftmost poisition where the target
could appear, then verify it.

This solution is especially useful for sorted arrays because it avoids overshooting and
naturally handles duplicates.

Time: O(log n)
Space: O(1)

*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l < nums.length && nums[l] == target) ? l : -1;
    }
}
