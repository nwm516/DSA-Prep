/*
Search a 2D Matrix

You are given an m x n 2-D integer array matrix and an integer target.

    Each row in matrix is sorted in non-decreasing order.
    The first integer of every row is greater than the last integer of the previous row.

Return true if target exists within matrix or false otherwise.

Can you write a solution that runs in O(log(m * n)) time?

Example 1:

Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10

Output: true

Example 2:

Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15

Output: false

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -10000 <= matrix[i][j], target <= 10000

*/

/*
Binary Search Solution

With each row in the matrix being sorted and with the rows being sorted by their first and last elements,
applying binary search twice would be a good approach.
    - First search over the rows:
        + Single out the row where the target could exist by comparing hte target with the row's
        first and last elements
    - Search inside that row:
        + Once correct row is found, perform a normal binary search within that row to check for target's presence

Doing so eliminates large portions of the matrix at each step and uses the sorted structure fully.

Time: O(log(m * n))
Space: O(1)

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
                int row = (top + bot) / 2;
                if (target > matrix[row][COLS - 1]) {
                    top = row + 1;
                } else if (target < matrix[row][0]) {
                    bot = row - 1;
                } else {
                    break;
                }
        }

        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
