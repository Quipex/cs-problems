/**
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * [-4, -1, -1, 0, 1, 2]
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  nums.sort((a, b) => a - b);
  const result = [];
  for (let p1 = 0; p1 < nums.length; p1++) {
    if (nums[p1] > 0) {
      // no reason to continue
      break;
    }
    // Avoid duplication
    if (p1 !== 0 && nums[p1 - 1] === nums[p1]) {
      continue;
    }

    let leftP = p1 + 1;
    let rightP = nums.length - 1;
    while (leftP < rightP) {
      const triplet = getTriplet(p1, leftP, rightP, nums);
      if (getSum(triplet) > 0) {
        rightP--;
      } else if (getSum(triplet) < 0) {
        leftP++;
      } else {
        result.push(triplet);
        leftP++;
        // Avoid duplication
        while (nums[leftP - 1] === nums[leftP] && rightP > leftP) {
          leftP++;
        }
      }
    }
  }
  return result;
};

function getTriplet(p1, p2, p3, nums) {
  return [nums[p1], nums[p2], nums[p3]];
}

function getSum(triplet) {
  return triplet[0] + triplet[1] + triplet[2];
}
