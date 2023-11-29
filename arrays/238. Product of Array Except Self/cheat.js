/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
  let numberOfZeros = 0;
  let multiplication = 1;
  let multiplicationWOZeros = 1;
  for (const num of nums) {
    if (num === 0) {
      numberOfZeros++;
    } else {
      multiplicationWOZeros *= num;
    }
    if (numberOfZeros > 1) {
      // No point calculating further, the answer would be all zeros
      return initArrayWithZeros(nums.length);
    }
    multiplication *= num;
  }
  return nums.map(num => {
    if (num === 0) {
      return multiplicationWOZeros;
    }
    return multiplication / num;
  })
};

function initArrayWithZeros(length) {
  const array = [];
  for (let i = 0; i < length; i++) {
    array.push(0);
  }
  return array;
}
