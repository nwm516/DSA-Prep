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
Recursion Solution

At every step, we can either climb 1 or 2 steps. So, if from any step i, we can
reach the top:
    - either i + 1 
    - or i + 2

This can be represented by a binary recursion tree where we try all possible paths.
    - if we land exactly on step n, that path counts as 1 valid way
    - if we cross n, it's an invalid path

This explores all possibilities using recursion.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n, 0, memo);
    }

    public int dfs(int n, int i, Map<Integer, Integer> memo) {
        if (i >= n) return i == n ? 1 : 0;
        if (memo.containsKey(i)) return memo.get(i);
        int result = dfs(n, i + 1, memo) + dfs(n, i + 2, memo);
        memo.put(i, result);
        return result;
    }
}
