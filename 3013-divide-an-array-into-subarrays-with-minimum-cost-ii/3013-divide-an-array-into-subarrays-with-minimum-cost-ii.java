import java.util.*;

class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();
    long sum = 0;
    int need, smallCnt = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        need = k - 1;

        // initial window [1 ... dist+1]
        for (int i = 1; i <= dist + 1; i++) {
            add(nums[i]);
        }

        long ans = nums[0] + sum;

        for (int i = dist + 2; i < nums.length; i++) {
            remove(nums[i - dist - 1]);
            add(nums[i]);
            ans = Math.min(ans, nums[0] + sum);
        }
        return ans;
    }

    void add(int x) {
        if (smallCnt < need) {
            insert(small, x);
            sum += x;
            smallCnt++;
        } else if (x < small.lastKey()) {
            int y = small.lastKey();
            erase(small, y);
            sum -= y;
            smallCnt--;

            insert(large, y);

            insert(small, x);
            sum += x;
            smallCnt++;
        } else {
            insert(large, x);
        }
    }

    void remove(int x) {
        if (small.containsKey(x)) {
            erase(small, x);
            sum -= x;
            smallCnt--;

            if (!large.isEmpty()) {
                int y = large.firstKey();
                erase(large, y);
                insert(small, y);
                sum += y;
                smallCnt++;
            }
        } else {
            erase(large, x);
        }
    }

    void insert(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    void erase(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
    }
}
