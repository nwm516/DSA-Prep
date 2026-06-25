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
Iteration Solution

This approach avoids recursion by using a loop to locate the node to delete and its parent.
Once found, the same three deletion cases are handled but we manually update parent pointers.

When the node has two children, we find the in-order successor, detach it from its position,
and replace the deleted node with it. Careful pointer manipulation is required to maintain
the tree structure.

Algo Approach:
    - Return null if root is null.
    - Use a loop to find target node (by means of key), tracking its parent.
    - Node not found? Return original root.
    - If node has 0/1 child:
        + Determine if child is left or right
        + Deleting root? Return child.
        + Otherwise, update parent's pointer to point to child
    - If node has 2 children:
        + Find in-order successor (leftmost node of right subtree) and its parent
        + Successor is not immediate right child? Update its parent's left pointer
        to the successor's right child, then set successor's right to the deleted
        node's right
        + Set successor's left to the deleted node's left
        + Update parent's pointer to successor, or return the successor
        if deleting the root

Time: O(h)
Space: O(1) extra space

 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        TreeNode parent = null;
        TreeNode cur = root;

        //Finding node to delete
        while (cur != null && cur.val != key) {
            parent = cur;
            if (key > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (cur == null) return root;

        // Node with only one child or no child
        if (cur.left == null || cur.right == null) {
            TreeNode child = (cur.left != null) ? cur.left : cur.right;
            if (parent == null) return child;
            if (parent.left == cur) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            // Node with two children
            TreeNode par = null;    // parent of right subtree's min. node
            TreeNode delNode = cur;
            cur = cur.right;
            while (cur.left != null){
                par = cur;
                cur = cur.left;
            }

            if (par != null) {  // If there was a left traversal
                par.left = cur.right;
                cur.right = delNode.right;
            }
            cur.left = delNode.left;

            if (parent == null) return cur; // if deleting root

            if (parent.left == delNode) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
        }

        return root;
    }
}