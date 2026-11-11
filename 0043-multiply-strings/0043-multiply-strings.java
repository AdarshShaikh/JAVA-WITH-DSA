class Solution {
  private static final int WIDTH = 8;               // 8 chữ số thập phân mỗi khối
    private static final long BASE = 100_000_000L;    // 10^8

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        long[] a = toChunks(num1), b = toChunks(num2);
        long[] pos = new long[a.length + b.length];

        // Nhân từng cặp khối, dồn phần nhớ về cuối
        for (int i = 0; i < a.length; i++) {
            long x = a[i];
            if (x == 0) continue;                     // bỏ qua khối 0, có lợi với số kiểu "1000...0"
            for (int j = 0; j < b.length; j++) {
                pos[i + j] += x * b[j];
            }
        }

        for (int k = 0; k < pos.length - 1; k++) {
            pos[k + 1] += pos[k] / BASE;
            pos[k] %= BASE;
        }

        int top = pos.length - 1;
        while (pos[top] == 0) top--;                  // tích > 0 nên luôn dừng được

        // Ghi thẳng ra mảng char từ phải sang trái, không tạo String trung gian
        char[] out = new char[(top + 1) * WIDTH];
        int p = out.length;
        for (int k = 0; k < top; k++) {
            long v = pos[k];
            for (int d = 0; d < WIDTH; d++) {         // khối giữa: luôn đủ 8 chữ số, tự có số 0 đệm
                out[--p] = (char) ('0' + v % 10);
                v /= 10;
            }
        }
        long v = pos[top];
        do {                                          // khối cao nhất: không đệm số 0
            out[--p] = (char) ('0' + v % 10);
            v /= 10;
        } while (v > 0);
        return new String(out, p, out.length - p);
    }

    // "123456789" → [23456789, 1]; tự ghép từng chữ số, không dùng parseInt
    private long[] toChunks(String s) {
        int len = s.length();
        long[] chunks = new long[(len + WIDTH - 1) / WIDTH];
        for (int c = 0, end = len; c < chunks.length; c++, end -= WIDTH) {
            int start = Math.max(0, end - WIDTH);
            long v = 0;
            for (int k = start; k < end; k++) v = v * 10 + (s.charAt(k) - '0');
            chunks[c] = v;
        }
        return chunks;
    }
}