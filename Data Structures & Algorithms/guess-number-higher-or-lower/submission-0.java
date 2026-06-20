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
Linear Search Solution

Simplest approach to this is to check every number from 1 to n until our target is found, and each guess
tells us whether or not we have found it correctly.
This method is slow for larger ranges since every number may possible need to be checked.

Time: O(n)
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
        for (int num = 1; num <= n; num++) {
            if (guess(num) == 0) return num;
        }
        return n;
    }
}