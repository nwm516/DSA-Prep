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
Inorder Traversal Solution

We will traverse the Binary Search Tree through inorder traversal. We will store the values
in an empty list arr and then perform inorder DFS, visiting the left subtree, adding the current
node's value to arr, and then visiting the right subtree.

After traversal, arr will be sorted and we will return arr[k-1].

Time: O(n)
Space: O(n)
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();

        dfs(root, arr);
        return arr.get(k-1);
    }

    private void dfs(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }

        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }
}
