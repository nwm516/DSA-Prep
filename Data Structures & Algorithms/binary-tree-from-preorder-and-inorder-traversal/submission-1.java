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
Hash Map + Depth First Search

In the basic DFS approach, we can search for root's position in inorder using linear search,
taking O(n) time per node. By precomputing a hash map from values to their indices in inorder,
we can find root's position in O(1) time. This also avoids creating new arrays
by passing indices that define the current subarray boundaries.

Approach:
    - Build a hash map, mapping each value in inorder (root-left-right) to its index
    - Maintain a global preorder index starting at 0
    - Define a recurisve function dfs(l, r) for the inorder range [l, r]
    - If l > r, return null (base case)
    - Get the root value from preorder at the current index, increment the index
    - Look up the root's position in the hash map (call it mid)
    - Recursively build left subtree with dfs (l, mid-1) and right subtree with dfs(mid+1, r)
    - Return root node

Time & Space: O(n)
 */

class Solution {
    int pre_idx = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        int root_val = preorder[pre_idx++];
        TreeNode root = new TreeNode(root_val);
        int mid = indices.get(root_val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;

    }
}
