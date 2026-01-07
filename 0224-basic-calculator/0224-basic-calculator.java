class Solution {
    public int calculate(String s) {
        int[] stack = new int[s.length()];
        int top = -1;
        int res = 0, num = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack[++top] = res;
                stack[++top] = sign;
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack[top--];
                res += stack[top--];
            }
        }
        return res + sign * num;
    }
}
