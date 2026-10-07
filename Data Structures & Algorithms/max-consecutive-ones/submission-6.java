/*
Given array, find max amount of consecutive 1's.

oneCounter int variable to keep track of total count at end.
runningTotal is the count within the loop of highest 1 count.

*/

class Solution {

    int oneCounter = 0; // final value to be returned
    int runningTotal = 0;   // count of the highest running amount

    public int findMaxConsecutiveOnes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                runningTotal++;
                oneCounter = runningTotal;
            } else if (nums[i] == 0) {
                oneCounter = 0;
            }
        }
        return oneCounter;
    }
}