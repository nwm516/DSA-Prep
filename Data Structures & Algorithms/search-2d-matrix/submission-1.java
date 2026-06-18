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
Staircase Search Solution

Consider that each row is sorted left to right and each column top to bottom. This means we can optimize our 
search and smartly check instead of visiting each cell.

Starting in the top right corner of the matrix:
    - current value greater than target? move left (values decrease)
    - smaller than target? move down (values increase)

Like walking down a staircase, each step eliminates an entire row or column.
We keep moving until we either find the target or move out of bounds.

Time:
Space:
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0]. length;
        int r = 0, c = n - 1;

        while (r < m && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}
