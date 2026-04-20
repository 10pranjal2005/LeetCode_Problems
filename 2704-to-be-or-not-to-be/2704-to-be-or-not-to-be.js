var expect = function(val) {
    return {
        toBe: function(x) {
            if (val === x) return true;
            throw new Error("Not Equal");
        },
        notToBe: function(x) {
            if (val !== x) return true;
            throw new Error("Equal");
        }
    };
};