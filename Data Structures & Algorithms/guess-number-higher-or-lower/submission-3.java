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

 /*
Ternary Search Solution (Tighter Version; Less API calls)

This solution cuts the search space into three parts versus two, utilizing two midpoints
and using the guess API on both.
Based on those results, we can eliminate either one-third or two-thirds of the search space.

This approach does not improve on the binary search for this problem
due to more API calls per iteration.

Time: O(log n)
Space: O(1)

 */

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (true) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            int g1 = guess(mid1);
            int g2 = guess(mid2);

            if (g1 == 0) return mid1; // mid1 matches picked number
            if (g2 == 0) return mid2; // mid2 matches picked number

            if (g1 + g2 == 0) {
                // mid1 too low AND mid2 too high, ergo! value is between them
                left = mid1 + 1;
                right = mid2 - 1;
            } else if (g1 == -1) {
                // mid1 itself is too high; pick is in lower third, below mid1
                right = mid1 - 1;
            } else {
                /* remaining case: mid1 was too low, and pick isn't between
                mid1 and mid2. 
                ergo! pick is in upper third, above mid2
                */
                left = mid2 + 1;
            }
        }
    }
}