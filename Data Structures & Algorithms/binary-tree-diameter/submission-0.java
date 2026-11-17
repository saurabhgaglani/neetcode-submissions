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

class Solution {
    int maxDepth = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        getAnswer(root);
        return maxDepth;
    }


    public int getAnswer(TreeNode root){
        int leftDepth = 0;
        int rightDepth = 0;
        if(root == null) return 0;

        leftDepth = getAnswer(root.left);
        rightDepth = getAnswer(root.right);
        maxDepth = Math.max((leftDepth+rightDepth), maxDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
