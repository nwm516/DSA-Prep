 /*
Guess Number Higher Or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

    0: your guess is equal to the number I picked (i.e. num == pick).
    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).

Return the number that I picked.

Example 1:

Input: n = 5, pick = 3

Output: 3

Example 2:

Input: n = 15, pick = 10

Output: 10

Example 3:

Input: n = 1, pick = 1

Output: 1

Constraints:

    1 <= pick <= n <= ((2^31)-1)

 */

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

 /*
Ternary Search Solution

This solution cuts the search space into three parts versus two, utilizing two midpoints
and using the guess API on both.
Based on those results, we can eliminate either one-third or two-thirds of the search space.

This approach does not improve on the binary search for this problem
due to more API calls per iteration.

Time: O(log3 n)
Space: O(1)

 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (true) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            // Midpoints returning the correctly chosen number
            if (guess(mid1) == 0) return mid1;
            if (guess(mid2) == 0) return mid2;

            /* 
            Number found in range BETWEEN mid1 and mid2
            since mid1 == 1 (go higher) and mid2 == -1 (go lower), which equals 0
            */
            if (guess(mid1) + guess(mid2) == 0) {
                left = mid1 + 1;
                right = mid2 - 1;  
            } else if (guess(mid1) == -1) {
                // Checks if mid1 was too high; lower third of range (below mid1) 
                right = mid1 - 1;
            } else {
                // Remaining clause: Checks if mid1 was too low; upper third of range (above mid2)
                left = mid2 + 1;
            }
        }
    }
}
