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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        helper(p, list1);
        helper(q, list2);

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) return false;
        }

        return true;
    }

    public List<Integer> helper(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(null);
            return list;
        }

        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);

        return list;
    }
}