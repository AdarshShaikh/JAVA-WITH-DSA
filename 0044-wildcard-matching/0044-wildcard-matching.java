class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int star = -1, match = 0;

        int m = s.length(), n = p.length();

        while (i < m) {
            if (j < n && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            else if (j < n && p.charAt(j) == '*') {
                star = j++;
                match = i;
            }
            else if (star != -1) {
                j = star + 1;
                i = ++match;
            }
            else {
                return false;
            }
        }

        while (j < n && p.charAt(j) == '*') {
            j++;
        }

        return j == n;
    }
}