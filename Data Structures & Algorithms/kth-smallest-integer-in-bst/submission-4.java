/*
Kth Smallest Integer in BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.

A binary search tree satisfies the following constraints:

    The left subtree of every node contains only nodes with keys less than the node's key.
    The right subtree of every node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees are also binary search trees.

Example 1:

Input: root = [2,1,3], k = 1

Output: 1

Example 2:

Input: root = [4,3,5,2,null], k = 4

Output: 5

Constraints:

    1 <= k <= The number of nodes in the tree <= 1000.
    0 <= Node.val <= 1000

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

We will implement Morris Traversal, allowing us inorder traversal using O(1) extra space by
temporarily creating a thread (a right pointer) from a node's predecessor back to the node.

For each node:
    - iF it has no left child: visit it directly
    - if it has a left child: find its inorder predecessor
        + if the predecessor's right pointer is empty: create a temporary link to the current node
        and move left
        + if the predecessor's righr pointer ALREADY points to the current node: renove the link,
        visit the node, and move right

We decrement k each time a node is visited.
The node where k becomes 0 is the k-th smallest.

Approach:
    - Set curr = root
    - While curr != null:
        + Case 1: No left child
            ~ Visit curr (decrement k)
            ~ If k == 0, return curr.val
            ~ Move to curr.right
        + Case 2: Has a left child
            ~ Find the inorder predecessor (pred = rightmost node in left subtree)
            ~ if pred.right is null:
                > create a temporary thread: pred.right = curr
                > move curr to its left child
            ~ Else (thread already exists):
                > remove the thread: pred.right = null
                > Vist curr (decrement k)
                > If k == 0, return curr.val
                > move to curr.right
    - If traversal ends without finding k nodes, return -1

Time: O(n)
Space: O(1)

 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                k--;
                if (k == 0) return curr.val;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) 
                    pred = pred.right;

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    k--;
                    if (k == 0) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
