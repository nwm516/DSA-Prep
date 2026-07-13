/*
Construct Binary Tree from Preorder and Inorder Traversal
Medium 

You are given two integer arrays preorder and inorder.

    preorder is the preorder traversal of a binary tree
    inorder is the inorder traversal of the same tree
    Both arrays are of the same size and consist of unique values.

Rebuild the binary tree from the preorder and inorder traversals and return its root.

Example 1:

Input: preorder = [1,2,3,4], inorder = [2,1,3,4]

Output: [1,2,3,null,null,null,4]

Example 2:

Input: preorder = [1], inorder = [1]

Output: [1]

Constraints:

    1 <= inorder.length <= 1000.
    inorder.length == preorder.length
    -1000 <= preorder[i], inorder[i] <= 1000
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
Depth First Search (Optimal) Solution

This avoids hash map utilization in favor of a limit-based approach. Instead of finding the 
root's position outright, this solution passes a "limit" that tells the program when to stop
building the left subtree. When the limit is encountered in inorder, the left subtree is complete.
The preorder index informs us of which node to create next, and the inorder index tells us
when we have finished a subtree.

Approach:
    - Maintain two global indices: preIdx for preorder and inIdx for inorder
    - Define a recursive function dfs(limit) that builds a subtree until it hits the limit value
    - If preIdx >= n, return null (no more nodes)
    - If inorder[inIdx] == limit, incremenet inIdx and return null (subtree complete)
    - Create a root node with preorder[preIdx], increment preIdx
    - Build left subtree with dfs(root.val) since nodes less than root appear before it in inorder
    - Build right subtree with dfs(limit) using original limit
    - Return root node. Start with dfs(infinity) or a value larger than any node

Time & Space: O(n)
 */

class Solution {
    int preIdx = 0;
    int inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if (preIdx >= preorder.length) return null;
        if (inorder[inIdx] == limit) {
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, limit);
        return root;
    }
}
