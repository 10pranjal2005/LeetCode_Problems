class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int p : factors(x)) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        Set<Integer> used = new HashSet<>();

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1) return steps;

                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                int val = nums[i];

                if (isPrime(val) && !used.contains(val)) {
                    used.add(val);

                    if (map.containsKey(val)) {
                        for (int idx : map.get(val)) {
                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }

    private List<Integer> factors(int x) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                res.add(i);

                if (i != x / i) {
                    res.add(x / i);
                }
            }
        }

        return res;
    }
}