/*
K Closest Points to Origin

You are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis plane. You are also given an integer k.

Return the k closest points to the origin (0, 0).

The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).

You may return the answer in any order.

Example 1:

Input: points = [[0,2],[2,2]], k = 1

Output: [[0,2]]

Explanation : The distance between (0, 2) and the origin (0, 0) is 2. The distance between (2, 2) and the origin is sqrt(2^2 + 2^2) = 2.82842. So the closest point to the origin is (0, 2).

Example 2:

Input: points = [[0,2],[2,0],[2,2]], k = 2

Output: [[0,2],[2,0]]

Explanation: The output [2,0],[0,2] would also be accepted.
*/

/*
Sorting Solution

In finding the closest k points to the origin, we compare points by their distance from the origin.
We can compare using squared distance since the actual distance uses a square root 
and square roots preserves ordering, which is sufficient for sorting.

By sorting points by this square distance, then the first k points in sorted order must be 
the k closest points.

Time: O(n log n)
Space: O(1) or O(n) (depending on the sorting algorithm)
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] *a[1])- 
        (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}
