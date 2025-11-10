class MyHashSet {
    private static final int SIZE = 1000;  // number of buckets
    private List<Integer>[] buckets;       // array of lists for chaining

    public MyHashSet() {
        buckets = new List[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] != null) {
            buckets[index].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].contains(key);
    }
}