class Fancy {

    static final long MOD = 1000000007;
    List<Long> seq;
    long mul = 1;
    long add = 0;

    public Fancy() {
        seq = new ArrayList<>();
    }

    public void append(int val) {
        long inv = modInverse(mul);
        long normalized = ((val - add + MOD) % MOD * inv) % MOD;
        seq.add(normalized);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;
        long val = seq.get(idx);
        return (int)((val * mul % MOD + add) % MOD);
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}