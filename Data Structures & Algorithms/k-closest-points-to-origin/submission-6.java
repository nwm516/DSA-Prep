/*
points[]: 2D array
points[i] = [x1, y1]

k = number of points needing to be returned closest to the origin

answers can be returned in any order

euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2))

since the actual distance uses a square root, and square root preserves ordering, we can instead compare using squared distance:
[d^2 = x^2 + y^2]

keeps computations simpler and is sufficient for sorting.

then, sorting all points by this squared distance indicates to us that the first k points in sorted order must be the k closest ones.

time: 0(n log n)
space: 0(1) or O(n) depending on the sorting algo
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - 
        (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);

    }
}
