
/*
Balanced Binary Tree

Given a binary tree, return true if it is height-balanced and false otherwise.

A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Input: root = [1,2,3,null,null,4]

Output: true

Example 2:

Input: root = [1,2,3,null,null,4,null,5]

Output: false

Example 3:

Input: root = []

Output: true

Constraints:

    The number of nodes in the tree is in the range [0, 1000].
    -1000 <= Node.val <= 1000

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*
Psuedocode

We are verifying whether a binary tree is height-balanced, and returning true if so.
If not, we return false.

All left and right subtrees of every node cannot differ in height
by no more than 1.

Approach:

the isBalanced function is present to compute height of subtrees, which will give the
height of a null node (return 0). If an imbalance is detected, returns -1,
effectively throwing any remaining tree-traversal processes null since
imbalance has already been established.

With leftHeight and rightHeight from recursive calls returning non-negative numbers,
or their heights, we still must determine whether or not their heights vary 
by a value greater than 1.
If so, return -1 again due to imbalance, effectively stopping any further checks.

This approach repeats recursively for all nodes, and follows the more brute force approach.

Time: O(n^2)
Space: O(n)

 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
