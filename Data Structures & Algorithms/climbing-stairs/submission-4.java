/*
Climbing Stairs

You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.

Return the number of distinct ways to climb to the top of the staircase.

Example 1:

Input: n = 2

Output: 2

Explanation:

    1 + 1 = 2
    2 = 2

Example 2:

Input: n = 3

Output: 3

Explanation:

    1 + 1 + 1 = 3
    1 + 2 = 3
    2 + 1 = 3

*/

/*
Dynamic Programming (Bottom-Up)

To reach step i, you can only come from:
    - step i - 1 (1 step)
    - step i - 2 (2 steps)

The total ways to reach step i is the sum of ways to reach the previous two steps, forming a Fibonacci-like pattern.

Time: O(n)
Space: O(n)

*/

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
