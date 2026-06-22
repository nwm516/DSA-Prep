
/* 
Koko Eating Bananas

You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.

You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.

Return the minimum integer k such that you can eat all the bananas within h hours.

Example 1:

Input: piles = [1,4,3,2], h = 9

Output: 2

Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.

Example 2:

Input: piles = [25,10,23,4], h = 4

Output: 25

Constraints:

    1 <= piles.length <= 1,000
    piles.length <= h <= 1,000,000
    1 <= piles[i] <= 1,000,000,000
*/

/*
PsuedoCode (Pre-solution integration)

Key Pieces:
    - int[] piles (piles[i] = numbers of bananas in ith pile)
    - int h = represents number of hours you have to eat all the bananas
    - int k = bananas-per-hour eating rate

Set banana-consumption rate (int k) range, with the low end being 1 and 
the upper bounds being the maximum value in piles. 
Initially I thought of a for loop to iterate through to find the upper value,
though Java has a way of finding this without the need of the loop:

                Arrays.stream(piles).max().getAsInt()

Using a mid-range value, we can calculate how many hours it takes Koko to finish
all the piles at that rate.
Within h hours? k could be the answer but a lower attempt can be attempted.
Doesn't fit within h hours? Go higher.
*/

/*
Binary Search Solution

Pretty much what I laid out in the above section. 

Time: O(n * log m)
Space: O(1)

*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right) {
            int k = (left + right) / 2;

            long totalTime = 0;

            for (int pile : piles) {
                totalTime += Math.ceil((double) pile / k);
            }
            if (totalTime <= h) {
                res = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return res;
    }
}
