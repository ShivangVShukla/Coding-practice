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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,0,list);
        return list;
    }
    private void helper(TreeNode node, int level, ArrayList<Integer> list){
        if(node ==null) return;
        if(level==list.size()) list.add(node.val);
        helper(node.right,level+1,list);
        helper(node.left,level+1,list);
    }
}