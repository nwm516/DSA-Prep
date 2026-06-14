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
Recursive Binary Search Solution

Binary search will repeatedly cut the search space in half. Instead of scanning the entire array,
the middle element is checked:
    - is it the target? return the index
    - target is larger? search only in the right half
    - target is smaller? search only in the left half

This recursive version will be a function that calls upon itself on the appropriate half
until the target is found or the range becomes invalid.

Time & Space: O(log n)

*/

class Solution {
    public int binary_search(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        return (nums[m] < target) ?
            binary_search(m + 1, r, nums, target) :
            binary_search(l, m - 1, nums, target);
    }

    public int search(int[] nums, int target) {
        return binary_search(0, nums.length - 1, nums, target);
    }
}
