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
Morris Traversal Solution

Like other Morris Traversal solutions, we'll build the tree iteratively without using a recursion stack
by means of correctly assigning nodes to temporarily store parent references, which imitates the call stack.
The nodes will be built as we iterate through preorder, connecting them via left/right pointers.
When we finish a left subtree, which is detected by matching the inorder sequence, the original structure is
restored by cleaning temporary links and moving up the tree.

Approach:
    - Create dummy head node and set curr to point to it
    - Iterate through preorder with index i (letter, not number...) and inorder with index j
    - Create a new node for preorder[i] and attach it as curr's right child, then move curr to this new node
    - While preorder[i] does not match inorder[j], keep creating left children (storing parent in right pointer)
    - WHen a match is found, increment j. While curr.right exists and matches inorder[j], clear the temporary
    right link and move up
    - Continue until all nodes are processed
    - Return head.right as the actual root

Time: O(n)
Space:
    - O(1) extra space
    - O(n) for output tree
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(0);
        TreeNode curr = head;
        int i = 0, j = 0, n = preorder.length;

        while (i < n && j < n) {
            curr.right = new TreeNode(preorder[i], null, curr.right);
            curr = curr.right;
            i++;
            while (i < n && curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i], null, curr);
                curr = curr.left;
                i++;
            }
            j++;
            while (curr.right != null && j < n && curr.right.val == inorder[j]) {
                TreeNode prev = curr.right;
                curr.right = null;
                curr = prev;
                j++;
            }
        }
        return head.right;
    }
}
