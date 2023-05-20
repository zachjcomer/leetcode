/*
https://leetcode.com/problems/apply-transform-over-each-element-in-array/description/?utm_campaign=PostD4&utm_medium=Post&utm_source=Post&gio_link_id=noqbNOv9

using map, pass (arg, index) to callback fn
*/

function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    return arr.map(fn);
};

/*
without map, iteration
*/

function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    var transform = [];
    for (var i = 0; i < arr.length; i++) {
        transform.push(fn(arr[i], i));
    }

    return transform;
};
