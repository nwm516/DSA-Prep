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
 Iterative Depth First Search Solution

 We will implement and explicit stack to simulate the recursive stack.

 Key insight: go as far left as possible, then process current node,
 and move to the right subtree.
 The stack helps us remember which nodes we still need to process after finishing
 the left subtrees.

Psuedocode

Initialize an empty result list and an empty stack.

Set current node to root.

While current node is not null OR stack is not empty:
    - while current node is not null, push it onto stack and move to its left child
    - pop a node from stack, add its value to the result
    - move to the right child of the popped node

Return the result list.

Post-correction Notes:

Creation of the outer method will own the list and returns the results.
The helper works recursively and adds to the list as it goes,
hence the void in the description (since no return value is needed).
The list gets passed by reference so every recursive call is adding to the same list.

Key takeaway:
Whenever collecting results across recursive calls, initialize the container
in the outer method and pass it down. 

Time: O(n)
Space: O(n) space for the stack, O(n) for output array

*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}