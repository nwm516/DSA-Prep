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

Depth First Search Solution

First element of the preorder array is always the root. We can find this root's position 
in the inorder array, which divides inorder into left and right subtrees. Elements before the
root in inorder belong to the left subtree, and anything after into the right subtree.
The same split applies to preorder. Recursively, we build left and right subtrees using the 
corresponding portions of both arrays.

Approach:
    - If either array is empty, return null (base case)
    - Create root node with the first element of preorder
    - Find the index of the root value in inorder (described as mid in the code)
    - Recursively build left subtree using preorder[1:mid+1] and inorder[0:mid]
    - Recursively build right subtree using preorder[mid+1:] and inorder[mid+1:]
    - Return root

Initial Impressions:

With the aim being O(n) for both time and space overall, this approach really appears
to me as covering ground that has already been tread, and I know there is a more succinct,
efficient soultion that this one doesn't capture well.
Using both the copyOfRange for both arrays and building the trees based upon those
just doesn't strike me as being as tight as it could possibly be, though this seems
to be more of the brute force approach (which is usually the case for the first solution presented).

Time: O(n^2)
Space: O(n)

 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = 1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
