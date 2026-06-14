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
Upper Bound Solution

This solution finds the first index where a value greater than the target appears.
In knowing that position, the actual target (if it exists) must be right before it.

Instead of directly searching for the target, we search for the boundary
where values stop being ≤ target, then we check whether the element just before
that boundary is the target.
*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l > 0 && nums[l - 1] == target) ? l - 1 : -1;
    }
}
