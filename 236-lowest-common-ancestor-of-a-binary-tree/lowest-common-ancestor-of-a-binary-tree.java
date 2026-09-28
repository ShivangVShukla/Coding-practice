/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        helper(root, list1, p);
        helper(root, list2, q);
        HashSet<TreeNode> set = new HashSet<>(list2);
        for(int i = list1.size() - 1; i >= 0; i--){
            if(set.contains(list1.get(i))){
                return list1.get(i);
            }
        }
        return null;
    }
    private void helper(TreeNode node, List<TreeNode> path, TreeNode target){
        if(node == null) return;
        path.add(node);
        if(node == target) return;
        if(node.left != null){
            helper(node.left, path, target);
            if(path.get(path.size() - 1) == target) return;
        }
        if(node.right != null){
            helper(node.right, path, target);
            if(path.get(path.size() - 1) == target) return;
        }
        path.remove(path.size() - 1);
    }
}