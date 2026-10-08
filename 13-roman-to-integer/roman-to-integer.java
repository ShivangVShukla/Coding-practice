class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                String pair = s.substring(i, i + 2);
                if (pair.equals("IV")) {
                    ans += 4;
                    i++;
                }
                else if (pair.equals("IX")) {
                    ans += 9;
                    i++;
                }
                else if (pair.equals("XL")) {
                    ans += 40;
                    i++;
                }
                else if (pair.equals("XC")) {
                    ans += 90;
                    i++;
                }
                else if (pair.equals("CD")) {
                    ans += 400;
                    i++;
                }
                else if (pair.equals("CM")) {
                    ans += 900;
                    i++;
                }
                else {
                    ans += value(s.charAt(i));
                }
            } else {
                ans += value(s.charAt(i));
            }
        }
        return ans;
    }
    int value(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000;
    }
}