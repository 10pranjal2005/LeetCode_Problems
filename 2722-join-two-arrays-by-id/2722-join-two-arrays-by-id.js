/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {

    let map = new Map();

    // Step 1: insert all elements from arr1
    for (let obj of arr1) {
        map.set(obj.id, obj);
    }

    // Step 2: merge elements from arr2
    for (let obj of arr2) {

        if (map.has(obj.id)) {

            // merge objects (arr2 overrides arr1)
            let merged = {
                ...map.get(obj.id),
                ...obj
            };

            map.set(obj.id, merged);

        } else {

            map.set(obj.id, obj);

        }
    }

    // Step 3: convert map values into array
    let result = Array.from(map.values());

    // Step 4: sort by id
    result.sort((a, b) => a.id - b.id);

    return result;
};