class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, mapping, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
            int index,
            String digits,
            String[] mapping,
            StringBuilder current,
            List<String> result) {

        // All digits are processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            current.append(letter);

            backtrack(index + 1, digits, mapping, current, result);

            // Remove the last character before trying the next one
            current.deleteCharAt(current.length() - 1);
        }
    }
}