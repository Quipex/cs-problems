/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    const numSet = new Set(nums);
    return nums.length === numSet.length;
};

console.log