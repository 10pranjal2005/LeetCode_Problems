class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;
        while (read < chars.length) {
            char curr = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == curr) {
                read++;
                count++;
            }
            chars[write++] = curr;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}
