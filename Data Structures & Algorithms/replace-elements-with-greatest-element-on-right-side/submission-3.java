/*
in arr, replace every element in the array with greatest element among elements to its right. replace last element with -1.

an easy way to approach this would to be in starting out by setting the last element to being -1 from the start.
from there, setting rightMax to equal the greater of the values between rightMax (based off of ans now) and the index of arr.

thinking outside of the box and using another space to move through the work and record answers while also iterating through the original array.

*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int rightMax = -1;

        for (int i = n - 1; i >= 0; i--){
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }
        return ans;
    }
}