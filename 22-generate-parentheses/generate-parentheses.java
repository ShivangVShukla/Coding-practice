class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String str, int open, int close, int n) {

        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        // '(' add kar sakte hain agar open < n
        if (open < n) {
            backtrack(ans, str + "(", open + 1, close, n);
        }

        // ')' tabhi add karenge jab close < open
        if (close < open) {
            backtrack(ans, str + ")", open, close + 1, n);
        }
    }
}