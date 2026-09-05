/* 
Reading in array of numbers, looking for consecutive 1's in a row.
For-loop, a current counter variable, a max counter a to count consecutive 1's,
staying in the loop for as long as there are numbers in the array.

Step through counting consecutive 1's, overwriting value if previous count is greater than what is currently registered.

At end, return value of max count.

Time: O(n)
Space: O(1)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0, maxCount = 0;

        for (int num : nums){
            if (num == 0) {
                /*
                This method works a lot better than what I initially thought through because it assigns maxCount with whatever the highest value of 1's seen so far has been, then effectively wipes the currentCount
                */
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            } else {
                currentCount++;
            }
        }
        return Math.max(maxCount, currentCount);
    }
}