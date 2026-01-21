class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);
    }

    int bs(int[] a, int x, int l, int r) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;
        if (a[m] == x) return m;
        return a[m] < x ? bs(a, x, m + 1, r) : bs(a, x, l, m - 1);
    }
}
