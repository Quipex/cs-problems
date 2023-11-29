/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function (nums) {
  if (nums.length === 0) {
    return 0;
  }
  const numsSet = new Set(nums);
  let maxSequence = 1;

  for (let number of numsSet) {
    if (!numsSet.has(number - 1)) {
      // This is the start of the sequence
      let sequence = 1;
      while (numsSet.has(number + sequence)) {
        sequence++;
      }
      maxSequence = Math.max(sequence, maxSequence);
    }
  }

  return maxSequence;
};
