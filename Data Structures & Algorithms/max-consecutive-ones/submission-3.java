/* 
Reading in array of numbers, looking for consecutive 1's in a row.
For-loop, a current counter variable, a max counter a to count consecutive 1's,
staying in the loop for as long as there are numbers in the array.

Step through counting consecutive 1's, overwriting value if previous count is greater than what is currently registered.

At end, return value of max count.

Time: O(n)
Space: O(n^2)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1) {
                currentCount++;
            } 
            else if (nums[i] == 0) {
                currentCount = 0;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }
}