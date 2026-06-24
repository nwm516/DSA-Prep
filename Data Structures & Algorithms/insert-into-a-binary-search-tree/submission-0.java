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

 /*
Binary Search Approach Solution

Time & Space: O(log n) [ideally] / O(n) [worst-case]

 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Establishing if current node is null
        // If so, return new node with value of val

        if (root == null) {
            return new TreeNode(val);
        }

        /* Greater than current node? 
        Recursive call with right child of current node */
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);

        /* Less than current node?
        Recursive call with left child of current node */
        } else if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // Returning current node after the recursive call
        return root;
    }
}