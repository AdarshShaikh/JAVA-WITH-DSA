class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            int len = s.length();
            StringBuilder sb = new StringBuilder(len * 2);

            for (int j = 0; j < len;) {
                char c = s.charAt(j);
                int k = j + 1;

                while (k < len && s.charAt(k) == c) {
                    k++;
                }

                sb.append(k - j).append(c);
                j = k;
            }

            s = sb.toString();
        }

        return s;
    }
}