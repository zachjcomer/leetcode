/*
https://leetcode.com/problems/counter-ii/description/?utm_campaign=PostD3&utm_medium=Post&utm_source=Post&gio_link_id=xRxVYOXo

return the type with appropriate methods
*/

var createCounter = function(init: number) {
    let n: number = init;
    return {
        increment: () => n = n + 1,
        decrement : () => n = n - 1,
        reset: () => n = init
    }
};
