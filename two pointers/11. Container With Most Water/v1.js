/**
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * left[0]: 1, right[8]:7, distance: 8, val: min(1,7) * 8
 *
 * @param {number[]} heights
 * @return {number}
 */
var maxArea = function (heights) {
  let maxArea = 0;
  let leftP = 0;
  let rightP = heights.length - 1;

  const MAX_POSSIBLE_HEIGHT = Math.pow(10, 4);

  while (leftP < rightP) {
    const leftH = heights[leftP];
    const rightH = heights[rightP];
    const distance = rightP - leftP;

    if (maxArea >= distance * MAX_POSSIBLE_HEIGHT) {
      return maxArea;
    }

    const currentArea = distance * Math.min(leftH, rightH);
    maxArea = Math.max(maxArea, currentArea);

    if (leftH <= rightH) {
      leftP++;
    } else {
      rightP--;
    }
  }
  return maxArea;
};
