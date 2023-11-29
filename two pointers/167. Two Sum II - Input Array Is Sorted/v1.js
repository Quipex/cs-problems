/**
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * p1: 2, target: 9, leftOver: 7
 * p2: 15 > leftOver
 * p2: 11 > leftOver
 * p2: 7 == leftOver!
 *
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * p1: 2, target: 6, leftOver: 4
 * p2: 4!
 *
 * Example 3:
 *
 * Input: numbers = [-10, -5, 0, 2], target = 2
 * Output: [3,4]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * p1: -10, target: 2, leftOver: 12
 * p2: 2 < leftOver, so p1 -> -5, leftOver: 7
 * p2: 2 < leftOver, so p1 -> 0, leftOver: 2
 * p2: 2 == 2!
 *
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  let leftP = 0, rightP = numbers.length - 1;
  let leftOver = target - numbers[leftP];
  while (numbers[rightP] !== leftOver) {
    if (rightP <= leftP) {
      throw Error('Unexpected state');
    }

    if (numbers[rightP] > leftOver) {
      rightP--;
    } else {
      leftP++;
    }
    leftOver = target - numbers[leftP]
  }
  return [leftP + 1, rightP + 1];
};

console.log(twoSum([5, 25, 75], 100));
