class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (num == 0){
                res = Math.max(res, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(res, count);
    }
}