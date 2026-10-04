class Solution {
    public boolean checkValidString(String s) {
        int low = 0;   // minimum possible number of unmatched '('
        int high = 0;  // maximum possible number of unmatched '('

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--;   // treat '*' as ')'
                high++;  // treat '*' as '('
            }

            // We can never have fewer than 0 unmatched '('
            low = Math.max(low, 0);

            // Too many ')' even in the best case
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}