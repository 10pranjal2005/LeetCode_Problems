import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String largestNumber(int[] nums) {
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_nums, (a, b) -> (b + a).compareTo(a + b));
        if (s_nums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : s_nums) {
            sb.append(s);
        }
        return sb.toString();
    }
}