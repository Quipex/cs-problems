/**
 * Input: nums = 1[5,2,3,4]1
 * Output: [24,60,40,30]
 *
 * +--->
 * result1: [1, 5, 10, 30]
 *                <----+
 * result2: [24, 60, 40, 30]
 *
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
  const result = [];

  let prevProd = 1;
  for (let i = 0; i < nums.length; i++) {
    result[i] = prevProd;
    prevProd *= nums[i];
  }

  let nextProd = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    result[i] *= nextProd;
    nextProd *= nums[i];
  }

  return result;
};
