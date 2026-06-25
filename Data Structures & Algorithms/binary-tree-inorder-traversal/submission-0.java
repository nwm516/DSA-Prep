/*
Binary Tree Inorder Traversal

You are given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,2,3,4,5,6,7]

Output: [4,2,5,1,6,3,7]

Example 2:

Input: root = [1,2,3,null,4,5,null]

Output: [2,4,1,5,3]

Example 3:

Input: root = []

Output: []

Constraints:

    0 <= number of nodes in the tree <= 100
    -100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
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

Return if node is null.

Left subtree traversal until leaf/no left child is reached.
Right subtree traversal until leaf node is hit.

Return to root. Same process on the right subtree of traversal as on the left.

Return root.

Post-correction Notes:

Creation of the outer method will own the list and returns the results.
The helper works recursively and adds to the list as it goes,
hence the void in the description (since no return value is needed).
The list gets passed by reference so every recursive call is adding to the same list.

Key takeaway:
Whenever collecting results across recursive calls, initialize the container
in the outer method and pass it down. 

Time & Space: O(n)
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null){
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}