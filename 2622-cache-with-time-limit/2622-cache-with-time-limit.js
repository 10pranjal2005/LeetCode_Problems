var TimeLimitedCache = function() {
    this.cache = new Map();
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    const now = Date.now();
    const exists = this.cache.has(key) && this.cache.get(key).expire > now;

    this.cache.set(key, {
        value,
        expire: now + duration
    });

    return exists;
};

TimeLimitedCache.prototype.get = function(key) {
    const data = this.cache.get(key);

    if (!data || data.expire <= Date.now()) {
        return -1;
    }

    return data.value;
};

TimeLimitedCache.prototype.count = function() {
    const now = Date.now();
    let total = 0;

    for (let [_, data] of this.cache) {
        if (data.expire > now) total++;
    }

    return total;
};