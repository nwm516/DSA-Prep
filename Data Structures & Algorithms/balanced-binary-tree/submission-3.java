/*
Balanced Binary Tree

Given a binary tree, return true if it is height-balanced and false otherwise.

A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Input: root = [1,2,3,null,null,4]

Output: true

Example 2:

Input: root = [1,2,3,null,null,4,null,5]

Output: false

Example 3:

Input: root = []

Output: true

Constraints:

    The number of nodes in the tree is in the range [0, 1000].
    -1000 <= Node.val <= 1000

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
Iterative DFS Solution

Like the recursive DFS solution, iterative DFS will compute height and balance
in one postorder traversal but this approach also simulates recursion using a stack.

The approach:
    - every node must be visited AFTER its children (hence postorder)
    - once both children of a node are processed, we already know their heights
    - Then:
        + check if the height difference is greater than or equal to 1
        + save the node's height (1 + max(left, right))

Any node imbalanced? Return false immediately.

Time and Space: O(n)

 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, last = null;
        Map<TreeNode, Integer> depths = new HashMap<>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    stack.pop();
                    int left = depths.getOrDefault(node.left, 0);
                    int right = depths.getOrDefault(node.right, 0);

                    if (Math.abs(left - right) > 1) return false;
                    depths.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return true;
    }
}
