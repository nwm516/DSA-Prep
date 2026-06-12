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
Brute Force Solution

Simplest approach is using a standard sorting algorithm. Since there are only
0's, 1's and 2's, sorting will naturally arrange them in the required order.

Time: O(n)
Space: O(1)
*/


class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}