/*
Sort Colors
Medium Topics Company Tags

You are given an array nums consisting of n elements where each element is an integer representing a color:

    0 represents red
    1 represents white
    2 represents blue

Your task is to sort the array in-place such that elements of the same color are grouped together and arranged in the order: red (0), white (1), and then blue (2).

You must not use any built-in sorting functions to solve this problem.

Example 1:

Input: nums = [1,0,1,2]

Output: [0,1,1,2]

Example 2:

Input: nums = [2,1,0]

Output: [0,1,2]

Constraints:

    1 <= nums.length <= 300.
    0 <= nums[i] <= 2.

*/

/*
Three Pointers (the First) Solution

We'll use the Dutch National Flag algo to partition the array into three sections in one pass,
maintaining the boundary of 0's (left), 2's on the right, and the current element being examined.

See a 0? Swap to the left section. 2? Swap to the right. 1's go in the middle.

Time: O(n)
Space: O(1)

*/

class Solution {
    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}