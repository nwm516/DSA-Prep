/*
Insert into a Binary Search Tree

You are given the root node of a binary search tree (BST) and a value val to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note: There may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Example 1:

Input: root = [5,3,9,1,4], val = 6

Output: [5,3,9,1,4,6]

Example 2:

Input: root = [5,3,6,null,4,null,10,null,null,7], val = 9

Output: [5,3,6,null,4,null,10,null,null,7,null,null,9]

Constraints:

    0 <= The number of nodes in the tree <= 10,000.
    -100,000,000 <= val, Node.val <= 100,000,000
    All the values Node.val are unique.
    It's guaranteed that val does not exist in the original BST.

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

Key Pieces:
    - root: root node of BST
    - val: needs to be inserted into tree

Return the root node of BST after insertion.

Traversal:

Establish if current node is null, return a new node with the current val.

Determine whether value is greater or less than node.
    - greater? traverse right subtree by recursive call with right child of current node.
    - lesser? traverse left subtree by recursive call with left child of current node.

Return current node after the recursive call.

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
Iterative Solution

Like recursion but implements a loop instead of the call stack,
traversing down the tree, comparing values at each node
to decide which direction to go.

When a null child is found in the direction needed to go,
we've determined the insertion point, so we create the new node and attach it.

This solution uses O(1) extra space due to not needing the recursion stack,
making it more memory-efficient for deep trees.

Time: O(h)
Space: O(1) extra space
 */

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Returning a new node with given value if null
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        while (true) {
            if (val > cur.val) {
                if (cur.right == null) {
                    // Inserting if cur.right null...
                    cur.right = new TreeNode(val);
                    return root;
                }
                // ...Otherwise, moving cur to cur.right
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    /* Checking if cur.left is null
                    and inserting if so */
                    cur.left = new TreeNode(val);
                    return root;
                }
                // Otherwise, move cur to cur.left
                cur = cur.left;
            }
        }
    }
}