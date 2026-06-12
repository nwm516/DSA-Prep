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
Quick Select Solution

We want k closest points but do not need them sorted,
which is perfect for QuickSelect, which is the same idea used in QuickSort's parition step:
    - pick a pivot pont
    - partition all points into:
        + points closer than the pivot
        + points farther than the pivot
    - after paritioning, the pivot ends at its correct position in the final sorted order
    - if the pivot ends up at index p:
        + if 'p == k', then the left side already contains the k closest points
        + if 'p < k', search the right half
        + if 'p > k', search the left half

This avoids fully sorting the array and runs in average O(N) time.

Time: O(n) [on average], O(n^2) [worst case]
Space: O(1)

*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int L = 0, R = points.length - 1;
        int pivot = points.length;

        while (pivot != k) {
            pivot = partition(points, L, R);
            if (pivot < k) {
                L = pivot + 1;
            } else {
                R = pivot - 1;
            }
        }
        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int partition(int[][] points, int l, int r) {
        int pivotIdx = r;
        int pivotDist = euclidean(points[pivotIdx]);
        int i = l;
        for (int j = l; j < r; j++) {
            if (euclidean(points[j]) <= pivotDist) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
            }
        }
        int[] temp = points[i];
        points[i] = points[r];
        points[r] = temp;
        return i;
    }

    private int euclidean(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
