/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let longestSubstr = 0;
  let leftP = 0;
  let rightP = 0;
  let visited = new Set();
  while ((rightP < s.length) && ((s.length - leftP) >= longestSubstr)) {
    const rChar = s[rightP];

    while (visited.has(rChar)) {
      const lChar = s[leftP];
      visited.delete(lChar);
      leftP++;
    }

    visited.add(rChar);
    longestSubstr = Math.max(longestSubstr, visited.size);
    rightP++;
  }
  return longestSubstr;
};
