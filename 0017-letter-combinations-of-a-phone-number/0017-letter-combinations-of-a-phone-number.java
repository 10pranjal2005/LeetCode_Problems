import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    void backtrack(String digits, int idx, StringBuilder cur) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            cur.append(c);
            backtrack(digits, idx + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
