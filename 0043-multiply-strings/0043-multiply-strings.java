class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();

        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";

        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; --i) {
            int a = num1.charAt(i) - 48;
            int pos = i + n;

            for (int j = n - 1; j >= 0; --j) {
                int sum = res[pos] + a * (num2.charAt(j) - 48);

                res[pos] = sum % 10;
                res[--pos] += sum / 10;
            }
        }

        int start = 0;
        while (start < m + n - 1 && res[start] == 0)
            start++;

        char[] ans = new char[m + n - start];

        for (int i = start; i < m + n; i++)
            ans[i - start] = (char) (res[i] + 48);

        return new String(ans);
    }
}