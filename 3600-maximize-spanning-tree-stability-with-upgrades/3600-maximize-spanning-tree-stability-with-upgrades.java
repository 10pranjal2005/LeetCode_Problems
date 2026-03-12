import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        // check mandatory edges cycle first
        DSU dsu = new DSU(n);
        int mustEdges = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (!dsu.union(e[0], e[1])) return -1;
                mustEdges++;
            }
        }

        if (mustEdges > n - 1) return -1;

        int left = 1, right = 200000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (can(n, edges, k, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right <= 0 ? -1 : right;
    }

    private boolean can(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int used = 0;
        int upgrades = k;

        for (int[] e : edges) {
            if (e[3] == 1) {
                int u = e[0], v = e[1], s = e[2];

                if (s < target) return false;

                if (!dsu.union(u, v)) return false;

                used++;
            }
        }

        List<int[]> normal = new ArrayList<>();
        for (int[] e : edges) {
            if (e[3] == 0) normal.add(e);
        }

        normal.sort((a, b) -> Integer.compare(b[2], a[2]));

        for (int[] e : normal) {

            int u = e[0], v = e[1], s = e[2];

            if (dsu.find(u) == dsu.find(v)) continue;

            if (s >= target) {
                dsu.union(u, v);
                used++;
            } 
            else if (upgrades > 0 && s * 2 >= target) {
                upgrades--;
                dsu.union(u, v);
                used++;
            }

            if (used == n - 1) return true;
        }

        return used == n - 1;
    }
}