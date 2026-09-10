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
    public int averageOfSubtree(TreeNode root) {
        if(root==null) return 0;
        int sum1=helper1(root);
        int size1=helper2(root);
        int avg=sum1/size1;
        int cnt=0;
        if(root.val==avg) cnt++;
        return cnt+averageOfSubtree(root.left)+
        averageOfSubtree(root.right);
    }
    public int helper1(TreeNode node){
        if(node==null) return 0;
        return node.val+helper1(node.left)+helper1(node.right);
    }
    public int helper2(TreeNode node){
        if(node==null) return 0;
        return 1+helper2(node.left)+helper2(node.right);
    }
}