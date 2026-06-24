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
Psuedocode

Key Pieces:
    - root: node reference of BST
    - key: element to be deleted in the BST

Return root node reference, which could be updated, of the BST.

Two ways to delete node:
    - Search for node to remove
    - Node found? Delete!

Removal Cases:

    - Case 1: Target has 0 or 1 children
        + Easy removal of node with no children.
        + 1 children case: parent node of deleted node will point to child of deleted node
    
    - Case 2: Target has 2 children
        + Replace with its in-order successor, which is the left-most node
        in the right subtree of target node (or smallest node among all nodes
        that are greater than the target node)
            -> this ensures resulting tree is still a valid binary search tree

Approach:

Establish clause for returning minimum value node of the BST

Establish removal clause:
    - Return null if root is null
    - Value greater than root.val? Remove root.right
    - Value less than root.val? Remove root.left

    Otherwise:
    - If root.left == null, return root.right
    - Else if root.right == null, return root.left
    - Else, reassign some values:
        + make a node with minValueNode(root.right)
        + root.val will be equal to that minValueNode(root.right)
        + then, root.right = remove(root.right, minNode.val)

    Return root, after all is said and done.

Time and Space: O(h) 
 */
class Solution {
    // Return the minimum value node of the BST
    public TreeNode minValueNode(TreeNode root) {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    
    // Remove a node and return the root of the BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
}