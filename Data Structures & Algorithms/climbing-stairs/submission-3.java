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
Dynamic Programming (Top-Down)

Optimized recursion solution.

While exploring choices (1 or 2 steps?), the same subproblems repeat many times.
Ex: number of ways from step i is always the same whenever we reach i.

This will be a lot like the Map solution, in that we store the results during the first computation
and will reuse it later. This is what Top-Down Dynamic Programming (Memoization) does.
Still working recursively but avoiding redundant work.

Time: O(n)
Space: O(n)
*/

class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
