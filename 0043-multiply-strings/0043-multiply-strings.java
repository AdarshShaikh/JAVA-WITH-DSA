class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();

        if (m == 1 && num1.charAt(0) == '0' ||
            n == 1 && num2.charAt(0) == '0') return "0";

        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int sum = res[i + j + 1]
                        + a * (num2.charAt(j) - '0');

                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder(m + n);
        int i = 0;

        while (i < m + n && res[i] == 0) i++;

        for (; i < m + n; i++) {
            ans.append((char) ('0' + res[i]));
        }

        return ans.toString();
    }
}