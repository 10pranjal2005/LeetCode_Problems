var createCounter = function(init) {
    let val = init;

    return {
        increment: function() {
            val++;
            return val;
        },
        decrement: function() {
            val--;
            return val;
        },
        reset: function() {
            val = init;
            return val;
        }
    };
};