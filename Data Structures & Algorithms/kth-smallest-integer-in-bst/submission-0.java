/*
Kth Smallest Integer in BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.

A binary search tree satisfies the following constraints:

    The left subtree of every node contains only nodes with keys less than the node's key.
    The right subtree of every node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees are also binary search trees.

Example 1:

Input: root = [2,1,3], k = 1

Output: 1

Example 2:

Input: root = [4,3,5,2,null], k = 4

Output: 5

Constraints:

    1 <= k <= The number of nodes in the tree <= 1000.
    0 <= Node.val <= 1000

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

Approach:
We're effectively returning whatever the stored value that correlates
to the integer k that lines up with the smallest integer ascending.

Since we're moving across the BST through inorder traversal,
we can stop at the kth node and return that value.

We can still move recursively through the entire tree but finding our
base case in the leftmost subtrees and starting our count from there.
From there, we should be able to run a counter
to keep track of where we are in relation to the kth value,
which should help with the traversals of right subtrees if right children
are present within subtrees.

Method:

Return null if node is null.

Helper function will call upon node, which starts with node.left.
Increment count by one (count++). If count == k, set result = node.val.
Call helper function on node.right.

Return result.

Time: O(n)
Space: O(h)
 */

class Solution {
    int count = 0;
    int result = 0;
    int k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;

        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        dfs(node.right);
    }
}
