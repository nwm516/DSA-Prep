class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        int idx = 0;
        for (int i = 0; i < 2; i++){
            for (int num : nums){
                ans[idx++] = num;
            }
        }
        return ans;

    }
}