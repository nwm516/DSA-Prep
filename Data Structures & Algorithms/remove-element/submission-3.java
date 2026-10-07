/*
nums array. int val.

remove all instances of val in nums in-place.
then return number of elements in nums which are not equal to val, which will be evaluated as k.

for acceptance:

- change the array nums so that the first k elements of nums contains the elements which are not equal to val. remaining elements of nums are not as important as the size of nums.

- return k

the goal I am getting caught up is the fact that we are only really focused on the first k-elements of the array, not about what else is in it beyond the kth value...

*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}