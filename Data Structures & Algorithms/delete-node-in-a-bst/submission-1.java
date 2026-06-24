/*
Delete Node in a BST

You are given a root node reference of a BST and a key, delete the node with the given key in the BST, if present. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Note: There can be multiple results after deleting the node, return any one of them.

Example 1:

Input: root = [5,3,9,1,4], key = 3

Output: [5,4,9,1]

Explanation: Another valid answer is:

Example 2:

Input: root = [5,3,6,null,4,null,10,null,null,7], key = 3

Output: [5,4,6,null,null,null,10,7]

Constraints:

    0 <= The number of nodes in the tree <= 10,000.
    -100,000 <= key, Node.val <= 100,000
    All the values Node.val are unique.

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
Recursion I Solution

To delete a node in a BST, we need to locate it first using the BST property:
left children are smaller, right children are larger.
Once found, we handle three cases:
    - node has no left child? replace it with its right child
    - no right child? replace with left child
    - Node has both children?
        + Locate in-order successor (smallest node in the right subtree),
        copy its value to current node, then delete successor node
            ~ this approach swaps values rather than restructuring pointers

Approach:

Root is null, return null.

Key greater than root's value? Recursively delete from right subtree
Key is less than root's value? Recursively delete from left subtree
Key matches root's value?
    - if no left child, return right child
    - if no right child, return left child
    - Otherwise, find in-order successor (leftmost node in right subtree),
    copy value to current node, and recursively delete the successor

Return the root.

Time and Space: O(h)
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            root.val = curr.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
}