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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null) return list;
        ArrayList<Integer> path=new ArrayList<>();
        helper(root,list,path);
        return list;
    }
    private void helper(TreeNode node,List<String> list,ArrayList<Integer> path){
        path.add(node.val);
        if(node.left==null && node.right==null) {
            String s="";
            for(int i=0;i<path.size();i++){
                if(i>0) s+="->";
                s+=path.get(i);
            }
            list.add(s);
            path.remove(path.size()-1);
            return;
        }
        if(node.left!=null){
            helper(node.left,list,path);
        }
        if(node.right!=null){
            helper(node.right,list,path);
        }
        path.remove(path.size()-1);
    }
}