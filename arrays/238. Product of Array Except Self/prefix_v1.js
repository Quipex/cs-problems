/**
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * prefix: [1, 2, 6, 24]
 * postfix: [24, 24, 12, 4]
 *
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
  const prevProds = [];
  for (let i = 0; i < nums.length; i++) {
    const prevProd = i === 0 ? 1 : prevProds[i - 1];
    prevProds[i] = nums[i] * prevProd;
  }

  const nextProds = [];
  for (let i = nums.length - 1; i > 0; i--) {
    const nextProd = i === nums.length - 1 ? 1 : nextProds[i + 1];
    nextProds[i] = nums[i] * nextProd;
  }

  const result = [];
  for (let i = 0; i < nums.length; i++) {
    const prevProd = i === 0 ? 1 : prevProds[i - 1];
    const nextProd = i === nums.length - 1 ? 1 : nextProds[i + 1];
    result[i] = prevProd * nextProd;
  }
  return result;
};
