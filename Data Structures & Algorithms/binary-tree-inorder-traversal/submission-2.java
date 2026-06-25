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
Morris Traversal Solution

This approach achieves O(1) extra space by temporarily modifying the tree structure.
The idea is to create a temporary link from the rightmost node of the left subtree
back to the current node.
This allows for a return to the current node after traversing the left subtree
without using a stack.

After processing, we remove the temporary link to restore the original tree.

Psudeocode:

Initialize current node to root.

While the current node is not null:
    - current node has no left child? Add its value to the result
    and move to the right child

    -Otherwise, find rightmost node in the left subtree (the inorder predecessor)

    -Predecessor's right pointer is null? Set it to current node (create a thread)
    and move to the left child

    - If predecessor's right pointer already points to the current node,
    remove the thread, add the current node's value to the result,
    and move to the right child

Return the result list.

Time: O(n)
Space: O(1) extra space / O(n) space for output array

 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return res;
    }
}