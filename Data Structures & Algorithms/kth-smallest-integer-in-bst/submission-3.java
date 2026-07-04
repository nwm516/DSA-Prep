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
Iterative DFS Solution

We will approach this solution without utilizing recursion outright by means of a stack.
    - Push all left nodes (go as deep as possible)
    - Pop the top node; this is the next smallest value
    - Move to its right subtree and repeat
    - When we pop the k-th node, we've reached our answer

This keeps from having to traverse the entire tree by stopping at the k-th smallest.

Approach:
    - Initialize an empty stack and set curr = root.
    - While either stack is not empty or curr is not null:
        + Push all left nodes into the stack (curr = curr.left)
        + Pop from the stack; this is the next smallest node
        + Decrement k. If k == 0, return that node's value
        + Move to the right subtree (curr = curr.right)
    - The popped k-th node is the answer

Time & Space: O(n)

 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }
}
