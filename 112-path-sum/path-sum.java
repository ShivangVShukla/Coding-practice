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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root ==null) return false;
        int sum=0;
        return helper(root,targetSum,sum);
    }
    private boolean helper(TreeNode node, int targetSum,int sum){
        sum+= node.val;
        if(node.left==null && node.right==null) return sum==targetSum;
        boolean left = false;
        boolean right = false;
        if(node.left!=null) left = helper(node.left,targetSum,sum);
        if(node.right!=null) right = helper(node.right,targetSum,sum);
        return left||right;
    }
}