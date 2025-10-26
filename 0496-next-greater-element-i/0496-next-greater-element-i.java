class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = new int[10001]; // Since nums[i] ≤ 10^4
        boolean[] seen = new boolean[10001];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                next[stack.pop()] = num;
            }
            stack.push(num);
            seen[num] = true;
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            ans[i] = seen[n] ? (next[n] == 0 ? -1 : next[n]) : -1;
        }

        return ans;
    }
}
